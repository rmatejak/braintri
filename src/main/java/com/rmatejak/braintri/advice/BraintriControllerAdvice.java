package com.rmatejak.braintri.advice;

import com.rmatejak.braintri.validation.ValidationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class BraintriControllerAdvice {

    @ExceptionHandler(value = ValidationException.class)
    @ResponseBody
    public Error handleBadRequestException (ValidationException e) {
        return new Error(e.getValidationMessage().getCode(),e.getValidationMessage().getMessage());
    }
}
