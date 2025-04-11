package com.api_store_management.api_store_management.util.validate;

import com.api_store_management.api_store_management.dto.ProductDto;
import com.api_store_management.api_store_management.dto.exception.FieldErrorResponse;
import com.api_store_management.api_store_management.exception.InsertProductException;
import com.api_store_management.api_store_management.util.validate.fields.NameValidateProduct;
import com.api_store_management.api_store_management.util.validate.fields.PriceValidate;
import com.api_store_management.api_store_management.util.validate.fields.ValidateTypeProduct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ValidateInputs {
    private final PriceValidate priceValidate;
    private final NameValidateProduct nameValidateProduct;
    private final ValidateTypeProduct validateTypeProduct;

    public ValidateInputs(PriceValidate priceValidate, NameValidateProduct nameValidateProduct, ValidateTypeProduct validateTypeProduct) {
        this.priceValidate = priceValidate;
        this.nameValidateProduct = nameValidateProduct;
        this.validateTypeProduct = validateTypeProduct;
    }

    public void processValidation(ProductDto productDto){
        List<FieldErrorResponse> allErrors = new ArrayList<>();

        allErrors.addAll(priceValidate.validate(productDto.price()));
        allErrors.addAll(nameValidateProduct.validate(productDto.name()));
        allErrors.addAll(validateTypeProduct.validate(productDto.productType()));

        if (!allErrors.isEmpty()){
            throw new InsertProductException(allErrors);
        }

    }
}
