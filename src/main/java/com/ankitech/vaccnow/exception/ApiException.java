package com.ankitech.vaccnow.exception;

import org.springframework.http.HttpStatus;

class ApiException extends Exception {
    private final HttpStatus code;

    ApiException(HttpStatus code, String msg) {
        super(msg);
        this.code = code;
    }

    public HttpStatus getCode() {
        return code;
    }
}
