package uz.pdp.g33springbootactiveuse.service.impl;

import org.springframework.stereotype.Service;
import uz.pdp.g33springbootactiveuse.dto.user.UserDTO;
import uz.pdp.g33springbootactiveuse.exception.UserNotFoundException;
import uz.pdp.g33springbootactiveuse.repository.UserRepository;
import uz.pdp.g33springbootactiveuse.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO getById(Long id) {
        return UserDTO.from(userRepository
                .findByIdAndEnabledIsTrue(id)
                .orElseThrow(
                        () -> new UserNotFoundException(
                                "User not found with id: " + id
                        )
                ));
    }
}
