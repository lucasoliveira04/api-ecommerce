package com.api_store_management.api_store_management.controller;

import com.api_store_management.api_store_management.modal.dto.User.UserDto;
import com.api_store_management.api_store_management.modal.entity.Usuario;
import com.api_store_management.api_store_management.service.User.AddUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final AddUser addUser;

    public UserController(AddUser addUser) {
        this.addUser = addUser;
    }

    @PostMapping("/")
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {
        Usuario request = addUser.addUser(userDto);

        if (request != null){
            return ResponseEntity.ok().body(request.toString());
        }

        return ResponseEntity.badRequest().build();
    }
}
