package com.rmatejak.braintri.validation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ValidationMessage {
    NAME_SIZE_NOT_CORRECT(422, "Validation error! Name size is not correct!"),
    SURNAME_SIZE_NOT_CORRECT(422, "Validation error! Surname size is not correct!"),
    EMAIL_SIZE_NOT_CORRECT(422, "Validation error! Email size is not correct!"),
    EMAIL_MATCH_NOT_CORRECT(422, "Validation error! Email match is not correct!"),
    USER_EXIST_BY_EMAIL(422, "Validation error! User is exist by this email!"),
    USER_NOT_EXIST_BY_ID(422, "Validation error! User not exist by id!");
    private final int code;
    private final String message;
}
