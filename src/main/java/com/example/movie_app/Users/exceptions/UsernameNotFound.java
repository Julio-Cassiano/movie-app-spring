package com.example.movie_app.Users.exceptions;

import lombok.Getter;

@Getter
public class UsernameNotFound extends RuntimeException {
    private final String username;

    public UsernameNotFound(String username) {
        super("Username "+username+" not exists: ");
        this.username = username;
    }
}
