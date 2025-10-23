package com.example.movie_app.infra;

import com.example.movie_app.Users.exceptions.EmailAlreadyExists;
import com.example.movie_app.Users.exceptions.UserNotFound;
import com.example.movie_app.Users.exceptions.UsernameAlreadyExists;
import com.example.movie_app.movies.exceptions.MovieNotFound;
import com.example.movie_app.Users.exceptions.UserNotAllowedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UsernameAlreadyExists.class)
    private ResponseEntity<Object> userAlreadyExists(UsernameAlreadyExists exception) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("error", "This username already exists: %s".formatted(exception.getUsername()));
        body.put("message", exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
    }

    @ExceptionHandler(EmailAlreadyExists.class)
    private ResponseEntity<Object> emailAlreadyExists(EmailAlreadyExists exception) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("error", "This email already exists: %s".formatted(exception.getEmail()));
        body.put("message", exception.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
    }

    @ExceptionHandler(UserNotFound.class)
    private ResponseEntity<Object> userNotFound(UserNotFound exception) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("error", "User not found: %s".formatted(exception.getId()));
        body.put("message", exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(MovieNotFound.class)
    private ResponseEntity<Object> movieNotFound(MovieNotFound exception) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("error", "Movie not found: %s".formatted(exception.getId()));
        body.put("message", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(UserNotAllowedException.class)
    private ResponseEntity<Object> userNotAllowed(UserNotAllowedException exception) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("error", "User not allowed ");
        body.put("message", exception.getMessage());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(body);
    }
}
