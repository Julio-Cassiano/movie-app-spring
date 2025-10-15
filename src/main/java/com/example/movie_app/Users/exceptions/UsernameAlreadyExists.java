package com.example.movie_app.Users.exceptions;

import lombok.Getter;

@Getter
public class UsernameAlreadyExists extends RuntimeException {
    private final String username;

    public UsernameAlreadyExists(String username) {
        super("Username "+username+" already exists: ");
        this.username = username;
    }
}
