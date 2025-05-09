package com.api_store_management.api_store_management.modal.repository;

import com.api_store_management.api_store_management.modal.entity.UserProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProductRepository extends JpaRepository<UserProduct, Integer> {
}
