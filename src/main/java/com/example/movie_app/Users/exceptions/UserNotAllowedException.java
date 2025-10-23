package com.example.movie_app.Users.exceptions;
import lombok.Getter;
import java.util.UUID;

@Getter
public class UserNotAllowedException extends RuntimeException {
    public UserNotAllowedException() {
        super("This user cannot update other users movies");
    }
}
