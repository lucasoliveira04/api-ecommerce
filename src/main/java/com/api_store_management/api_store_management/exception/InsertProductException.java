package com.api_store_management.api_store_management.exception;

import com.api_store_management.api_store_management.dto.exception.FieldErrorResponse;

import java.util.List;

public class InsertProductException extends BaseException {
  public InsertProductException(List<FieldErrorResponse> fieldErrorResponses) {
    super(fieldErrorResponses);
  }

  @Override
  protected String messagePersonalized() {
    return fieldErrorResponses.size() == 1 ?
            "Erro de validação ao inserir o produto." :
            "Erro(s) de validação ao inserir o produto.";
  }
}
