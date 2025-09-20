package com.example.movie_app.Users.controller;

import com.example.movie_app.Users.dtos.UserRecordDto;
import com.example.movie_app.Users.models.UsersModel;
import com.example.movie_app.Users.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor

public class UserController {
    private final UsersService userService;

    @PostMapping
    public ResponseEntity<UsersModel> addUser(@RequestBody UserRecordDto userRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(userRecordDto));
    }
}
