package com.api_store_management.api_store_management.controller;

import com.api_store_management.api_store_management.dto.ProductDto;
import com.api_store_management.api_store_management.modal.Product;
import com.api_store_management.api_store_management.service.Produtct.AddProductService;
import com.api_store_management.api_store_management.service.Produtct.ListProduct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/${version_api}/product")
public class ProductController {

    private final AddProductService addProductService;
    private final ListProduct listProduct;

    public ProductController(AddProductService addProductService, ListProduct listProduct) {
        this.addProductService = addProductService;
        this.listProduct = listProduct;
    }

    @GetMapping
    public ResponseEntity<?> getAllProduct(){
        List<?> getAll = listProduct.products();
        return ResponseEntity.ok().body(getAll);
    }

    @PostMapping
    public ResponseEntity<Product> created(@RequestBody ProductDto productDto){
        Product product = addProductService.createdProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
}
