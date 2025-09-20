package com.example.movie_app.Users.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UserRecordDto(
    String name,
    @NotBlank
    String username,
    @Email
    String email,
    LocalDate birthDate,
    @NotNull
    String password
) {}
