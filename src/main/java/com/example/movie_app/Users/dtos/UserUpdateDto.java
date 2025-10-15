package com.example.movie_app.Users.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Optional;

public record UserUpdateDto(
        Optional<String> name,
        @NotBlank
        Optional<String> username,
        @Email
        Optional<String> email,
        Optional<LocalDate> birthDate,
        @NotNull
        Optional<String> password
) {}