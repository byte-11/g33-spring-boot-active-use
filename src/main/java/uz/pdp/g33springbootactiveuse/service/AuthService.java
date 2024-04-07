package uz.pdp.g33springbootactiveuse.service;

import uz.pdp.g33springbootactiveuse.dto.user.UserLoginDTO;
import uz.pdp.g33springbootactiveuse.dto.user.UserSignUpDTO;
import uz.pdp.g33springbootactiveuse.dto.web.JwtTokenResponse;

public interface AuthService {
    JwtTokenResponse login(UserLoginDTO dto);

    JwtTokenResponse signUp(UserSignUpDTO dto);
}
