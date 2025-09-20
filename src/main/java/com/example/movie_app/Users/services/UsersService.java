package com.example.movie_app.Users.services;

import com.example.movie_app.Users.dtos.UserRecordDto;
import com.example.movie_app.Users.dtos.UserResponseDto;
import com.example.movie_app.Users.exceptions.EmailAlreadyExists;
import com.example.movie_app.Users.exceptions.UsernameAlreadyExists;
import com.example.movie_app.Users.models.UsersModel;
import com.example.movie_app.Users.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UserRepository userRepository;

    @Transactional //serve para atomicidade (tudo ou nada) rollback
    public UsersModel addUser(UserRecordDto userRecordDto) {
        userRepository.findByUsername(userRecordDto.username()).ifPresent(existingUser -> {
            throw new UsernameAlreadyExists(existingUser.getUsername());
        });

        userRepository.findByEmail(userRecordDto.email()).ifPresent(existingEmail -> {
            throw new EmailAlreadyExists(existingEmail.getEmail());
        } );

        UsersModel user = new UsersModel();
        user.setName(userRecordDto.name());
        user.setUsername(userRecordDto.username());
        user.setEmail(userRecordDto.email());
        user.setBirthDate(userRecordDto.birthDate());
        user.setPasswordHash(userRecordDto.password());

        return userRepository.save(user);
    }

    public List<UserResponseDto> getAllUsers() {
        List<UsersModel> users = userRepository.findAll();

        return users.stream().map(user -> new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                user.getBirthDate()
        )).toList();
    }

}
