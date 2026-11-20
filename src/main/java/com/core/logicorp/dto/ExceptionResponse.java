package com.core.logicorp.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class ExceptionResponse {
    private String status;
    private String error;
    private String message;
    private Instant timestamp;

    public ExceptionResponse(String status, String error, String message, Instant timestamp) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.timestamp = timestamp;
    }
}
