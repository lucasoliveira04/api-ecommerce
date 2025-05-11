package com.api_store_management.api_store_management.controller;

import com.api_store_management.api_store_management.dto.UserDto;
import com.api_store_management.api_store_management.modal.entity.User;
import com.api_store_management.api_store_management.modal.repository.UserRepository;
import com.api_store_management.api_store_management.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto){
        User userRequest = userService.addUser(userDto);

        if (userRequest != null){
            return ResponseEntity.ok(userRequest);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> listUsers = userService.getAllUser();

        if (listUsers != null && !listUsers.isEmpty()){
            return ResponseEntity.ok(listUsers);
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody UserDto userDto){
        User updatedUser = userService.updateUser(id, userDto);

        if (updatedUser != null){
            return ResponseEntity.ok(updatedUser);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteAllUsers(){
        if (userRepository.findAll().isEmpty()){
            return ResponseEntity.notFound().build();
        }

        userService.deleteAllUsers();
        return ResponseEntity.ok().build();
    }
}
