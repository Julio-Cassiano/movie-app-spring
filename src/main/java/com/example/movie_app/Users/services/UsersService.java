package com.example.movie_app.Users.services;

import com.example.movie_app.Users.dtos.UserRecordDto;
import com.example.movie_app.Users.models.UsersModel;
import com.example.movie_app.Users.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UserRepository userRepository;

    @Transactional //serve para atomicidade (tudo ou nada) rollback
    public UsersModel addUser(UserRecordDto userRecordDto) {
        UsersModel user = new UsersModel();
        user.setName(userRecordDto.name());
        user.setUsername(userRecordDto.username());
        user.setEmail(userRecordDto.email());
        user.setBirthDate(userRecordDto.birthDate());
        user.setPasswordHash(userRecordDto.password());

        return userRepository.save(user);
    }

}
