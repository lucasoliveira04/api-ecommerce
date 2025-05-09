package com.api_store_management.api_store_management.modal.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private BigDecimal price;
    private String description;

    @OneToMany(mappedBy = "product")
    private List<UserProduct> userProducts;
}
