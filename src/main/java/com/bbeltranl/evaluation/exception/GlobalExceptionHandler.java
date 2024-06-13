package com.bbeltranl.evaluation.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * GlobalExceptionHandler is a central class for handling exceptions across the whole application.
 * <p>
 * This class uses the {@link RestControllerAdvice} annotation to define global exception handling logic.
 * It provides methods to handle specific types of exceptions and returns appropriate HTTP responses.
 * </p>
 *
 * @author bbeltranl
 * @version 1.0
 * @since 2024-06-13
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles exceptions thrown when method arguments fail validation checks.
     * <p>
     * This method catches {@link MethodArgumentNotValidException} exceptions,
     * extracts field-specific error messages, and returns a {@link ResponseEntity} containing these messages
     * with a HTTP status code of {@code 400 BAD REQUEST}.
     * </p>
     *
     * @param ex the exception thrown when method arguments are not valid
     * @return a {@link ResponseEntity} containing a map of field errors and their messages
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    /**
     * Handles exceptions thrown when bean validation constraints are violated.
     * <p>
     * This method catches {@link ConstraintViolationException} exceptions,
     * extracts property path-specific error messages, and returns a {@link ResponseEntity} containing these messages
     * with a HTTP status code of {@code 400 BAD REQUEST}.
     * </p>
     *
     * @param ex the exception thrown when validation constraints are violated
     * @return a {@link ResponseEntity} containing a map of property path errors and their messages
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleConstraintViolationExceptions(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.put(violation.getPropertyPath().toString(), violation.getMessage());
        }
        return ResponseEntity.badRequest().body(errors);
    }
}