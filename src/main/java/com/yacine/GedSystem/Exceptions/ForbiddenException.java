package com.yacine.GedSystem.Exceptions;

import org.springframework.http.HttpStatus;

public class ForbiddenException extends BaseException{

    public ForbiddenException(String message) {
        super(message);
    }
    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.FORBIDDEN;
    }
}
