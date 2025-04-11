package com.api_store_management.api_store_management.dto.exception;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponse(String status,
                            String message,
                            String path,
                            LocalDateTime timestamp,
                            List<FieldErrorResponse> listErrors) {}