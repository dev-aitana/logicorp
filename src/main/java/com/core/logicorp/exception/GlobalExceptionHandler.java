package com.core.logicorp.exception;

import com.core.logicorp.dto.ExceptionResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.Instant;
import java.util.Arrays;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handle404(EntityNotFoundException ex) {
        return new ExceptionResponse("404", HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), Instant.now());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handle400(MethodArgumentTypeMismatchException ex) {
        String mensaje = "";
        Class<?> requiredType = ex.getRequiredType();
        if (requiredType != null && requiredType.isEnum()) {
            mensaje = "Valor no válido '" + ex.getValue() + "' para el parámetro '" + ex.getName() + "'. Valores permitidos: " + Arrays.toString(requiredType.getEnumConstants());
        } else {
            String tipoEsperado = (requiredType != null) ? requiredType.getSimpleName() : "desconocido";
            mensaje = "Valor no válido '" + ex.getValue()
                    + "' para el parámetro '" + ex.getName()
                    + "'. Se esperaba un valor de tipo " + tipoEsperado;
        }
        return new ExceptionResponse("400", HttpStatus.BAD_REQUEST.getReasonPhrase(), mensaje, Instant.now());
    }

}
