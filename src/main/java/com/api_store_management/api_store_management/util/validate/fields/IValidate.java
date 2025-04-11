package com.api_store_management.api_store_management.util.validate.fields;

import com.api_store_management.api_store_management.dto.exception.FieldErrorResponse;

import java.util.List;

public interface IValidate<T>{
    List<FieldErrorResponse> validate(T value);
}
