package com.core.logicorp.exception;

import com.core.logicorp.dto.ExceptionResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handle404(EntityNotFoundException ex) {
        return new ExceptionResponse("404", HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), Instant.now());
    }

}
