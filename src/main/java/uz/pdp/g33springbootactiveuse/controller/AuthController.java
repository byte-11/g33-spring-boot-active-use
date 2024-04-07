package uz.pdp.g33springbootactiveuse.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.g33springbootactiveuse.dto.user.UserSignUpDTO;
import uz.pdp.g33springbootactiveuse.dto.user.UserLoginDTO;
import uz.pdp.g33springbootactiveuse.dto.web.JwtTokenResponse;
import uz.pdp.g33springbootactiveuse.service.impl.AuthServiceImpl;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    private final AuthServiceImpl authServiceImpl;

    public AuthController(AuthServiceImpl authServiceImpl) {
        this.authServiceImpl = authServiceImpl;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<JwtTokenResponse> signUp(
         @RequestBody @Valid final UserSignUpDTO dto
    ) {
        return ResponseEntity.ok(authServiceImpl.signUp(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtTokenResponse> login(
            @RequestBody @Valid UserLoginDTO dto
    ){
        return ResponseEntity.ok(authServiceImpl.login(dto));
    }
}
