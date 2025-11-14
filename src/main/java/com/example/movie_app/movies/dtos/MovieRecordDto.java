package com.example.movie_app.movies.dtos;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public record MovieRecordDto(
        String name,
        String synopsis,
        LocalDate releaseDate,
        Integer durationInSeconds,
        String imagePath,
        String username,
        Set<String> directorNames) {}
