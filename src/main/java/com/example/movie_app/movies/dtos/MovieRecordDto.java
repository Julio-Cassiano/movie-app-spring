package com.example.movie_app.movies.dtos;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public record MovieRecordDto(
        String name, String synopsis,
        LocalDate release_date, Integer duration_in_seconds,
        String image_path, Set<String> director_names) {}
