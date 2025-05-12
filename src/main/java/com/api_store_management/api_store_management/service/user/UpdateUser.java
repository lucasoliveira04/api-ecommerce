package com.api_store_management.api_store_management.service.user;

import com.api_store_management.api_store_management.dto.UserDto;
import com.api_store_management.api_store_management.modal.entity.User;
import com.api_store_management.api_store_management.modal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UpdateUser {
    private final UserRepository userRepository;

    public UpdateUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User updateUser(Integer id, UserDto userDto){
        return userRepository.findById(id).map(user -> {
            user.setUsername(userDto.username());
            user.setName(userDto.name());
            user.setEmail(userDto.email());
            user.setPassword(userDto.password());
            user.setCreatedAt(LocalDateTime.now());
            return userRepository.save(user);
        }).orElse(null);
    }
}
