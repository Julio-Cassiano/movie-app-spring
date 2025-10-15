package com.example.movie_app.Users.exceptions;

import lombok.Getter;

import java.util.UUID;

@Getter
public class UserNotFound extends RuntimeException {
    private final UUID id;

    public UserNotFound(UUID id) {
        super("Username with id "+id+" not exists: ");
        this.id = id;
    }
}
