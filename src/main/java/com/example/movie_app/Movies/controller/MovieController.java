package com.example.movie_app.Movies.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @GetMapping
    public ResponseEntity helloWorld() {
        return ResponseEntity.ok("Hello World");
    }
}
