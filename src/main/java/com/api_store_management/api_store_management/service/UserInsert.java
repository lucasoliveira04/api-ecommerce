package com.api_store_management.api_store_management.service;

import com.api_store_management.api_store_management.modal.dto.UserRequest;
import com.api_store_management.api_store_management.modal.entity.User;
import com.api_store_management.api_store_management.modal.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserInsert {
    private final UserRepository userRepository;

    public UserInsert(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void insert(UserRequest user) {
        User userEntity = new User(user.name(), user.username(), user.email(), user.telephne(), user.password());
        userRepository.save(userEntity);
    }
}
