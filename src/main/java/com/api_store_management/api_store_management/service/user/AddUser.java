package com.api_store_management.api_store_management.service.user;

import com.api_store_management.api_store_management.dto.UserDto;
import com.api_store_management.api_store_management.modal.entity.User;
import com.api_store_management.api_store_management.modal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AddUser {

    private final UserRepository userRepository;

    public AddUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(UserDto userDto){
        User user = new User(userDto.username(), userDto.name(), userDto.email(), userDto.password(), LocalDateTime.now());
        userRepository.save(user);
        return user;
    }
}
