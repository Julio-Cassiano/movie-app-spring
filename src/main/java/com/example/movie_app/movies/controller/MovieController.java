package com.example.movie_app.movies.controller;

import com.example.movie_app.movies.dtos.MovieRecordDto;
import com.example.movie_app.movies.dtos.MovieResponseDto;
import com.example.movie_app.movies.dtos.MovieUpdateDto;
import com.example.movie_app.movies.services.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponseDto> getMovieById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getMovieById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MovieResponseDto> updateMovie(@PathVariable("id") Long id, @RequestBody
    MovieUpdateDto movieUpdateDto) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.updateMovie(movieUpdateDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable("id") Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
