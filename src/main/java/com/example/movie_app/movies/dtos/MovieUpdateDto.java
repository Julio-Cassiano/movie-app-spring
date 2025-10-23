package com.example.movie_app.movies.dtos;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Set;

public record MovieUpdateDto(
        String name,
        String synopsis,
        LocalDate releaseDate,
        Integer durationInSeconds,
        String imagePath,
        Set<String> directorNames
) {}
