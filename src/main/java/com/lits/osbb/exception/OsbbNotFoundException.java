package com.lits.osbb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OsbbNotFoundException extends RuntimeException {
    public OsbbNotFoundException(String s) {
        super();
    }
}
