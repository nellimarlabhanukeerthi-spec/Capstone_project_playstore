package com.playstore.appms.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AppNotFoundException.class)
    public ResponseEntity<?> handleNotFound(AppNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
