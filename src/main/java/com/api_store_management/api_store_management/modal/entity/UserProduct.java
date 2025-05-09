package com.api_store_management.api_store_management.modal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class UserProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario user;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
