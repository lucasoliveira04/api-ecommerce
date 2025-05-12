package com.api_store_management.api_store_management.modal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity(name = "user_entity")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;
    private String name;
    private String email;
    private String password;
    private LocalDateTime createdAt;

    public User(String username, String name, String email, String password, LocalDateTime createdAt) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }
}
