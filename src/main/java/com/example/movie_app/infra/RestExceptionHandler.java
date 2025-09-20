package com.example.movie_app.infra;

import com.example.movie_app.Users.exceptions.EmailAlreadyExists;
import com.example.movie_app.Users.exceptions.UsernameAlreadyExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UsernameAlreadyExists.class)
    private ResponseEntity<String> userAlreadyExists(UsernameAlreadyExists exception) {
        String errorMessage = "This username already exists: '%s'".formatted(exception.getUsername());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }

    @ExceptionHandler(EmailAlreadyExists.class)
    private ResponseEntity<String> emailAlreadyExists(EmailAlreadyExists exception) {
        String errorMessage = "This email already exists: '%s'".formatted(exception.getEmail());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }
}
