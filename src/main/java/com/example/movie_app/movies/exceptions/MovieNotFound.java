package com.example.movie_app.movies.exceptions;

import lombok.Getter;

@Getter
public class MovieNotFound extends RuntimeException {
    private final long id;

    public MovieNotFound(long id) {
        super("No such movie with id "+ id);
        this.id = id;
    }
}
