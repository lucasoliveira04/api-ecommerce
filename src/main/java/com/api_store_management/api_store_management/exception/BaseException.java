package com.api_store_management.api_store_management.exception;

import com.api_store_management.api_store_management.dto.exception.FieldErrorResponse;
import lombok.Getter;

import java.util.List;

@Getter
abstract public class BaseException extends RuntimeException {
    protected final List<FieldErrorResponse> fieldErrorResponses;

    public BaseException(List<FieldErrorResponse> fieldErrorResponses) {
        super();
        this.fieldErrorResponses = fieldErrorResponses;
    }

    @Override
    public String getMessage(){
      return messagePersonalized();
    }


    protected abstract String messagePersonalized();
}
