package com.azvtech.consortiumdatasourceservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Fellipe Toledo
 */
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> genericException(Exception ex) {
        ApiErrorResponse apiErrorResponse = ApiErrorResponse
                .builder()
                .timestamp(LocalDateTime.now())
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .errors(List.of(ex.getMessage()))
                .build();
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({
            ResourceNotFoundException.class,
    })
    public ResponseEntity<ApiErrorResponse> notFoundException(RuntimeException ex) {
        ApiErrorResponse apiErrorResponse = ApiErrorResponse
                .builder()
                .timestamp(LocalDateTime.now())
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.name())
                .errors(List.of(ex.getMessage()))
                .build();
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> argumentNotValidException(MethodArgumentNotValidException ex) {
        List<String> errorList = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());
        ApiErrorResponse apiErrorResponse = ApiErrorResponse
                .builder()
                .timestamp(LocalDateTime.now())
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.name())
                .errors(errorList)
                .build();
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }

}
