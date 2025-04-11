package com.api_store_management.api_store_management.util.validate.product.fields;

import com.api_store_management.api_store_management.dto.exception.FieldErrorResponse;
import com.api_store_management.api_store_management.enums.ProductType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ValidateTypeProduct implements IValidate<String>{

    @Override
    public List<FieldErrorResponse> validate(String value) {

        List<FieldErrorResponse> errors = new ArrayList<>();
        List<ProductType> productTypeList = Arrays.asList(ProductType.values());

        boolean isValid = productTypeList.stream()
                .anyMatch(type -> type.toString().equals(value));

        if (!isValid){
            errors.add(new FieldErrorResponse("productType", "Tipo de produto não existe. Tipos de produto: " + productTypeList));
        }

        return errors;
    }
}
