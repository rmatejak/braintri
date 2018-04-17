package com.rmatejak.braintri.advice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Error {

    private final int code;
    private final String message;
}
