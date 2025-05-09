package com.api_store_management.api_store_management.service.User;

import com.api_store_management.api_store_management.modal.dto.User.UserDto;
import com.api_store_management.api_store_management.modal.entity.Usuario;
import com.api_store_management.api_store_management.modal.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AddUser {
    private final UserRepository userRepository;

    public AddUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Usuario addUser(UserDto userDto){
        Usuario user = new Usuario(userDto.username(), userDto.password(), userDto.email());
        userRepository.save(user);
        return user;
    }
}
