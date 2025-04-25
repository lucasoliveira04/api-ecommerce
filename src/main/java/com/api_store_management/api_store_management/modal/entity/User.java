package com.api_store_management.api_store_management.modal.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
public class User {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    private String name;
    @Column(unique=true)
    private String username;
    private String email;
    @Column(unique=true)
    private String telephone;
    private String password;

    public User() {}

    public User(String name, String username, String email, String telephone, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
    }
}
