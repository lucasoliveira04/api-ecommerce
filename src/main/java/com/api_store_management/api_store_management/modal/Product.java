package com.api_store_management.api_store_management.modal;

import com.api_store_management.api_store_management.enums.ProductType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "productType")
    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Product(String name, String description, Double price, LocalDateTime createdAt, String productType) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdAt = createdAt;
        this.productType = ProductType.valueOf(productType);
    }
}
