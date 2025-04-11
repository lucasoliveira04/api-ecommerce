package com.api_store_management.api_store_management.util.validate.product.fields;

import com.api_store_management.api_store_management.dto.exception.FieldErrorResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NameValidateProduct implements IValidate<String>{
    @Override
    public List<FieldErrorResponse> validate(String value) {
        List<FieldErrorResponse> errors = new ArrayList<>();
        String[] letterNotPermission = {"~~, ^, "};

        String field = "name";

        if (value == null){
            errors.add(new FieldErrorResponse(field, "O nome não pode ser null."));
        } else {
            if (value.isBlank()){
                errors.add(new FieldErrorResponse(field, "O nome não pode ser vazio."));
            } else if (!value.matches("^[\\p{L}0-9\\-\\/() ]+$")) {
                errors.add(new FieldErrorResponse(field, "O nome não pode conter caracteres especiais"));
            }
        }
        return errors;
    }
}
