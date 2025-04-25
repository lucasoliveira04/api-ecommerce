package com.api_store_management.api_store_management.modal.repository;

import com.api_store_management.api_store_management.modal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
