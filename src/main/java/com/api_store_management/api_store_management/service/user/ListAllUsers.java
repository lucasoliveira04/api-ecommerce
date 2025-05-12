package com.api_store_management.api_store_management.service.user;

import com.api_store_management.api_store_management.modal.entity.User;
import com.api_store_management.api_store_management.modal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllUsers {

    private final UserRepository userRepository;

    public ListAllUsers(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }
}
