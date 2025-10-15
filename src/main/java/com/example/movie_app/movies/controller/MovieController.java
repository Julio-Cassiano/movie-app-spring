package com.example.movie_app.movies.controller;

import com.example.movie_app.movies.dtos.MovieRecordDto;
import com.example.movie_app.movies.dtos.MovieResponseDto;
import com.example.movie_app.movies.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieResponseDto> addMovie(@RequestBody MovieRecordDto movieRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.addMovie(movieRecordDto));
    }

    @GetMapping
    public ResponseEntity<List<MovieResponseDto>> getAllMovies() {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getAllMovies());
    }
}
