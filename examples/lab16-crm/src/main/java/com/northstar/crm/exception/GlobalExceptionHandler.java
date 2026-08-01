package com.northstar.crm.exception;

import jakarta.validation.ConstraintViolation;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GlobalExceptionHandler {

    public ErrorResponse fromBusiness(BusinessException ex) {
        List<ErrorResponse.FieldError> errors = new ArrayList<>();
        return new ErrorResponse(
                Instant.now().toString(),
                ex.getStatusHint(),
                ex.getCode(),
                ex.getMessage(),
                ex.getCorrelationId(),
                errors);
    }

    public ErrorResponse fromValidation(
            Set<? extends ConstraintViolation<?>> violations, String correlationId) {
        List<ErrorResponse.FieldError> errors = new ArrayList<>();
        for (ConstraintViolation<?> v : violations) {
            errors.add(new ErrorResponse.FieldError(v.getPropertyPath().toString(), v.getMessage()));
        }
        return new ErrorResponse(
                Instant.now().toString(),
                400,
                "VALIDATION_FAILED",
                "Validation failed",
                correlationId,
                errors);
    }

    public ErrorResponse fromUnexpected(Exception ex, String correlationId) {
        List<ErrorResponse.FieldError> errors = new ArrayList<>();
        return new ErrorResponse(
                Instant.now().toString(),
                500,
                "INTERNAL_ERROR",
                "Unexpected server error",
                correlationId,
                errors);
    }
}