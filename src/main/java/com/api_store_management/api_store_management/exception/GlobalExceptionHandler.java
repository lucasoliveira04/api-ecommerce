package com.api_store_management.api_store_management.exception;

import com.api_store_management.api_store_management.dto.exception.ErrorResponse;
import com.api_store_management.api_store_management.dto.exception.FieldErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InsertProductException.class)
    public ResponseEntity<?> errorHandleInsertProduct(HttpServletRequest request, InsertProductException ex){
        ErrorResponse error = new ErrorResponse(
                HttpStatus.BAD_REQUEST.toString(),
                ex.getMessage(),
                request.getRequestURI(),
                LocalDateTime.now(),
                ex.getFieldErrorResponses()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> errorHandleHttp(HttpServletRequest request, HttpMessageNotReadableException ex){
        ErrorResponse error = new ErrorResponse(
                HttpStatus.BAD_REQUEST.toString(),
                ex.getMessage(),
                request.getRequestURI(),
                LocalDateTime.now(),
                List.of(new FieldErrorResponse("body", ex.getMostSpecificCause().getMessage()))
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
