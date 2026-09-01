package com.canor.climbtracker.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.canor.climbtracker.dto.ApiErrorResponse;
import com.canor.climbtracker.dto.ValidationErrorResponse;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.validation.FieldError;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SetterNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleSetterNotFound(SetterNotFoundException exception) {
        ApiErrorResponse response = new ApiErrorResponse(404,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ClimbingProblemNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleClimbingProblemNotFound(ClimbingProblemNotFoundException exception) {
        ApiErrorResponse response = new ApiErrorResponse(404, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        ValidationErrorResponse response = new ValidationErrorResponse(400, "Validation Failed", errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(InvalidSortFieldException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidSortField(InvalidSortFieldException ex) {
        ApiErrorResponse response = new ApiErrorResponse(400, ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(InvalidSortDirectionException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidSortDirection(InvalidSortDirectionException ex) {
        ApiErrorResponse response = new ApiErrorResponse(400, ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    
}
