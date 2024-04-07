package uz.pdp.g33springbootactiveuse.service.impl;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.g33springbootactiveuse.domain.User;
import uz.pdp.g33springbootactiveuse.dto.user.UserLoginDTO;
import uz.pdp.g33springbootactiveuse.dto.user.UserSignUpDTO;
import uz.pdp.g33springbootactiveuse.dto.web.JwtTokenResponse;
import uz.pdp.g33springbootactiveuse.provider.JwtTokenProvider;
import uz.pdp.g33springbootactiveuse.repository.UserRepository;
import uz.pdp.g33springbootactiveuse.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public JwtTokenResponse signUp(final UserSignUpDTO dto) {
        if (userRepository.existsByEmailAndEnabledTrue(dto.email())) {
            throw new IllegalArgumentException("Email already registered");
        }
        User user = User.builder()
                .username(dto.username())
                .email(dto.email())
                .password(passwordEncoder.encode(dto.password()))
                .build();

        userRepository.save(user);
        return  new JwtTokenResponse(jwtTokenProvider.generateToken(user), null);
    }

    public JwtTokenResponse login(final UserLoginDTO dto) {
        final var optionalUser = userRepository.findByEmail(dto.email());
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException(dto.email());
        }

        if (!passwordEncoder.matches( dto.password(), optionalUser.get().getPassword())) {
            throw new BadCredentialsException("Bad credentials");
        }

        return new JwtTokenResponse(
                jwtTokenProvider.generateToken(optionalUser.get()),
                null
        );
    }
}
