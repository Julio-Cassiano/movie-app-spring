package com.example.movie_app.Users.dtos;

import java.time.LocalDate;
import java.util.UUID;

public record UserResponseDto(
        String ID,
        String name,
        String username,
        String email,
        LocalDate birthDate
) {}
