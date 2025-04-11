package com.api_store_management.api_store_management.service.Produtct;

import com.api_store_management.api_store_management.modal.Product;
import com.api_store_management.api_store_management.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListProduct {
    private final ProductRepository productRepository;;

    public ListProduct(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> products(){
        List<Product> list = productRepository.findAll();
        return list;
    }
}
