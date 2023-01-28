package com.yacine.GedSystem.Exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;


@ControllerAdvice
public class ApiExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
        ErrorDetails error= new ErrorDetails("server error",request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(BaseException.class)
        public ResponseEntity<ErrorDetails> handleApiException(BaseException ex, WebRequest request) {
            ErrorDetails details= new ErrorDetails(ex.getMessage(),request.getDescription(false));
            return new ResponseEntity<ErrorDetails>(details,ex.getStatusCode());
        }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ValidationError validationError=new ValidationError();
        validationError.setUri(request.getDescription(false));

        List<FieldError>fieldErrors=ex.getBindingResult().getFieldErrors();
        fieldErrors.forEach(error -> {
            validationError.addError(error.getDefaultMessage());
        });
        return new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST);
    }
}

