package uz.pdp.g33springbootactiveuse.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record UserSignUpDTO(
        @NotBlank String username,
        @Email String email,
        @NotBlank @Length(min = 8, max = 255) String password
){
}