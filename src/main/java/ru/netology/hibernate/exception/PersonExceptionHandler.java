package ru.netology.hibernate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * PersonExceptionHandler
 *
 * @author Viktor_Loskutov
 */
@RestControllerAdvice
public class PersonExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RuntimeException.class)
    String handleRuntimeException(RuntimeException e) {
        return e.getMessage();
    }
}