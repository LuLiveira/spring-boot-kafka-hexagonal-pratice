package com.lucas.culture.adapter.in.controllers.v1.exception.handler;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ErrorMessageResponse {
    private final int status;
    private final String message;
    private List<ApiError> errors;

    public ErrorMessageResponse(int status, String message, List<FieldError> fieldErrors) {
        this.status = status;
        this.message = message;
        addErrors(fieldErrors);
    }

    private void addErrors(List<FieldError> fieldErrors) {
        errors = new ArrayList<>();
        fieldErrors.forEach(f -> errors.add(new ApiError(f.getField(), f.getDefaultMessage())));
    }
}
