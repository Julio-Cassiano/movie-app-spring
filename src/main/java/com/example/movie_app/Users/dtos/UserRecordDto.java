package com.example.movie_app.Users.dtos;

import java.time.LocalDate;

public record UserRecordDto(
    String name,
    String username,
    String email,
    LocalDate birthDate,
    String password
) {}
