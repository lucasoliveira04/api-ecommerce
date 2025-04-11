package com.api_store_management.api_store_management.util.validate.fields;

import com.api_store_management.api_store_management.dto.exception.FieldErrorResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PriceValidate implements IValidate<Double>{
    private final int casasDecimais = 2;

    @Override
    public List<FieldErrorResponse> validate(Double value) {
        List<FieldErrorResponse> erros = new ArrayList<>();

        String field = "price";

        if (value == null){
            erros.add(new FieldErrorResponse(field, "O valor do produto não pode ser nulo"));
        } else {
            if (value < 0){
                erros.add(new FieldErrorResponse(field, "O valor do produto não pode ser negativo"));
            }
            String[] parts = String.valueOf(value).split("\\.");

            if (parts.length == 2 && parts[1].length() > casasDecimais){
                erros.add(new FieldErrorResponse(field, "O valor do produto não pode ter mais de " + casasDecimais + " casas decimais"));
            }
        }

        return erros;
    }
}
