package com.api_store_management.api_store_management.service.Produtct;

import com.api_store_management.api_store_management.dto.ProductDto;
import com.api_store_management.api_store_management.modal.Product;
import com.api_store_management.api_store_management.repository.ProductRepository;
import com.api_store_management.api_store_management.util.validate.ValidateInputs;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AddProductService {

    private final ProductRepository productRepository;
    private final ValidateInputs validateInputs;

    public AddProductService(ProductRepository productRepository, ValidateInputs validateInputs) {
        this.productRepository = productRepository;
        this.validateInputs = validateInputs;
    }

    public Product createdProduct(ProductDto productDto){
        validateInputs.processValidation(productDto);

        Product product = new Product(productDto.name(), productDto.description(),
                productDto.price(), LocalDateTime.now(), productDto.productType());
        productRepository.save(product);
        return product;
    }
}
