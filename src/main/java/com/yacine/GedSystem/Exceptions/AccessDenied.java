package com.yacine.GedSystem.Exceptions;

import org.springframework.http.HttpStatus;

public class AccessDenied extends BaseException{

    public AccessDenied(String message) {
        super(message);
    }
    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.FORBIDDEN;
    }
}
