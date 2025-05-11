package com.api_store_management.api_store_management.dto;

import java.time.LocalDateTime;

public record UserDto(String username, String name, String email, String password,
                      LocalDateTime createdAt){
}