package uz.pdp.g33springbootactiveuse.dto.user;


import uz.pdp.g33springbootactiveuse.domain.User;

public record UserDTO(
        Long id,
        String username,
        String email,
        long roles
)  {

    public static UserDTO from(User user) {
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRoles()
        );
    }
}