package com.example.JJShop.exceptions;

import com.example.JJShop.model.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Response> notFoundExceptionHandle(NotFoundException notFoundException) {
        return new ResponseEntity<>(
                Response.builder()
                        .date(LocalDate.now())
                        .message(List.of(notFoundException.getMessage()))
                        .statusCode(HttpStatus.NOT_FOUND.name())
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(AlreadyCreatedException.class)
    public ResponseEntity<Response> AlreadyCreatedExceptionHandle(AlreadyCreatedException alreadyCreatedException) {
        return new ResponseEntity<>(
                Response.builder()
                        .date(LocalDate.now())
                        .message(List.of(alreadyCreatedException.getMessage()))
                        .statusCode(HttpStatus.CONFLICT.name())
                        .build(),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            errors.add(((FieldError) error).getField().concat(" - " + error.getDefaultMessage()));
        }
        return new ResponseEntity<>(
                Response.builder()
                        .date(LocalDate.now())
                        .message(errors)
                        .statusCode(HttpStatus.BAD_REQUEST.name())
                        .build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity<Response> handleAuthenticationFailed(AuthenticationFailedException authenticationFailedException) {
        return new ResponseEntity<>(
                Response.builder()
                        .date(LocalDate.now())
                        .message(List.of(authenticationFailedException.getMessage()))
                        .statusCode(HttpStatus.FORBIDDEN.name())
                        .build(),
                HttpStatus.FORBIDDEN
        );
    }
}
