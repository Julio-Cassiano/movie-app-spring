package com.example.movie_app.Users.controller;

import com.example.movie_app.Users.dtos.UserRecordDto;
import com.example.movie_app.Users.dtos.UserResponseDto;
import com.example.movie_app.Users.models.UsersModel;
import com.example.movie_app.Users.services.UsersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")

public class UserController {
    private final UsersService userService;

    @PostMapping("/user")
    public ResponseEntity<UsersModel> addUser(@RequestBody @Valid UserRecordDto userRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(userRecordDto));
    }

    @GetMapping()
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }
}
