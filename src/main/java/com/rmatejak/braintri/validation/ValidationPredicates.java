package com.rmatejak.braintri.validation;

public class ValidationPredicates {

    public static void lenght (Integer min, Integer max, String value, ValidationMessage message){
        if(value == null || value.length() < min || value.length() > max){
            throw new ValidationException(message);
        }
    }

    public static void emailMatcher (String value, ValidationMessage message){
        String matcher = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if (!value.matches(matcher)) {
            throw new ValidationException(message);
        }
    }
}
