package com.yacine.GedSystem.Exceptions;

import org.springframework.http.HttpStatus;

public class ConflictException extends BaseException{
    public ConflictException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }

}
