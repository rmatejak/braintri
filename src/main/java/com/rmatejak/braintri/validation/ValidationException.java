package com.rmatejak.braintri.validation;

import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException{
    private final ValidationMessage validationMessage;

    public ValidationException(ValidationMessage validationMessage){
        super(validationMessage.getMessage());
        this.validationMessage = validationMessage;
    }
}
