package com.example.movie_app.movies.dtos;


import java.time.LocalDate;
import java.util.Set;

public record MovieResponseDto(
        Long id,
        String name,
        String synopsis,
        LocalDate release_date,
        Integer duration_in_seconds,
        String image_path,
        String username,
        Set<String> director_names) {}
