package com.example.movie_app.Users.exceptions;

import lombok.Getter;

@Getter
public class EmailAlreadyExists extends RuntimeException {
    private final String email;

    public EmailAlreadyExists(String email){
        super("Email '%s' already exists: " + email);
        this.email = email;
    }
}
