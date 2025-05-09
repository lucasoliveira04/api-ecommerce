package com.api_store_management.api_store_management.modal.repository;

import com.api_store_management.api_store_management.modal.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
