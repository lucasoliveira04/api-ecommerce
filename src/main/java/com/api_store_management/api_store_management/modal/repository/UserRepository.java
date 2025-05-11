package com.api_store_management.api_store_management.modal.repository;

import com.api_store_management.api_store_management.modal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}