package com.api_store_management.api_store_management.modal.dto.User;

import java.io.Serializable;

public record UserDto(String username, String email, String password) implements Serializable {
}