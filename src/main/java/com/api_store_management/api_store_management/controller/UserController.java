package com.api_store_management.api_store_management.controller;

import com.api_store_management.api_store_management.modal.dto.UserRequest;
import com.api_store_management.api_store_management.service.UserInsert;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserInsert userInsert;

    public UserController(UserInsert userInsert) {
        this.userInsert = userInsert;
    }

    @PostMapping("/create-user/post")
    public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest){
        userInsert.insert(userRequest);
        return ResponseEntity.ok().body(userRequest);
    }
}
