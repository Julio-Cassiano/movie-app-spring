package com.example.movie_app.movies.dtos;


import java.time.LocalDate;
import java.util.Set;

public record MovieResponseDto(
        Long id,
        String name,
        String synopsis,
        LocalDate releaseDate,
        Integer durationInSeconds,
        String imagePath,
        String username,
        Set<String> directorNames) {}
