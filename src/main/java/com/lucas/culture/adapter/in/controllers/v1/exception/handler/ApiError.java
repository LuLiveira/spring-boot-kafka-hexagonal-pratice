package com.lucas.culture.adapter.in.controllers.v1.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiError{
    private String field;
    private String message;
}
