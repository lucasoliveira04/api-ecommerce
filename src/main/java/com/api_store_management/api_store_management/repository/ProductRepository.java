package com.api_store_management.api_store_management.repository;

import com.api_store_management.api_store_management.modal.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    void deleteById(Integer id);

    @Query("select p from product p where p.name like 'L%' ")
    List<Product> namesProductForIntL();
}