package com.example.movie_app.review.dtos;

public record ReviewRecordDto(
    String comment,
    Integer rating,
    Long movieId
) {}
