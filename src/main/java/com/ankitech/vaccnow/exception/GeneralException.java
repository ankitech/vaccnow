package com.ankitech.vaccnow.exception;

import org.springframework.http.HttpStatus;

public class GeneralException extends ApiException {
    private final HttpStatus code;

    public GeneralException(HttpStatus code, String msg) {
        super(code, msg);
        this.code = code;
    }
}