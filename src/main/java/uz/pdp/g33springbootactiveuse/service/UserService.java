package uz.pdp.g33springbootactiveuse.service;

import uz.pdp.g33springbootactiveuse.dto.user.UserDTO;

public interface UserService {
    UserDTO getById(Long id);
}
