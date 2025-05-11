package com.api_store_management.api_store_management.service;

import com.api_store_management.api_store_management.dto.UserDto;
import com.api_store_management.api_store_management.modal.entity.User;
import com.api_store_management.api_store_management.modal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.name());
        user.setUsername(userDto.username());
        user.setEmail(userDto.email());
        user.setPassword(userDto.password());
        user.setCreatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }

    public User updateUser(Integer id, UserDto userDto) {
        return userRepository.findById(id).map(user -> {
            user.setName(userDto.name());
            user.setUsername(userDto.username());
            user.setEmail(userDto.email());
            user.setPassword(userDto.password());
            user.setCreatedAt(LocalDateTime.now());
            return userRepository.save(user);
        }).orElse(null);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public void deleteAllUsers(){
        userRepository.deleteAll();
    }
}
