package com.api_store_management.api_store_management.controller;

import com.api_store_management.api_store_management.dto.UserDto;
import com.api_store_management.api_store_management.modal.entity.User;
import com.api_store_management.api_store_management.service.user.AddUser;
import com.api_store_management.api_store_management.service.user.DeleteUser;
import com.api_store_management.api_store_management.service.user.ListAllUsers;
import com.api_store_management.api_store_management.service.user.UpdateUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final ListAllUsers listAllUsers;
    private final AddUser addUser;
    private final UpdateUser updateUser;
    private final DeleteUser deleteUser;

    public UserController(ListAllUsers listAllUsers, AddUser addUser, UpdateUser updateUser, DeleteUser deleteUser) {
        this.listAllUsers = listAllUsers;
        this.addUser = addUser;
        this.updateUser = updateUser;
        this.deleteUser = deleteUser;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = listAllUsers.allUsers();

        if (users == null) return ResponseEntity.badRequest().build();
        if (users.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody UserDto user) {
        User request = addUser.addUser(user);

        if (request == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(request);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Integer userId, @RequestBody UserDto user) {
        User request = updateUser.updateUser(userId, user);

        if (request == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(request);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer userId) {
        User request = deleteUser.deleteUser(userId);
        if (request == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(request);
    }

}
