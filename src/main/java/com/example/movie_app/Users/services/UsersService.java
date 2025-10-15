package com.example.movie_app.Users.services;

import com.example.movie_app.Users.dtos.UserRecordDto;
import com.example.movie_app.Users.dtos.UserResponseDto;
import com.example.movie_app.Users.dtos.UserUpdateDto;
import com.example.movie_app.Users.exceptions.EmailAlreadyExists;
import com.example.movie_app.Users.exceptions.UserNotFound;
import com.example.movie_app.Users.exceptions.UsernameAlreadyExists;
import com.example.movie_app.Users.models.UsersModel;
import com.example.movie_app.Users.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UserRepository userRepository;

    @Transactional //serve para atomicidade (tudo ou nada) rollback
    public UserResponseDto addUser(UserRecordDto userRecordDto) {
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

        userRepository.save(user);

        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                user.getBirthDate()
        );
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

    public UserResponseDto getUserById(UUID id) {
        UsersModel user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFound(id));

        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                user.getBirthDate()
        );
    }

    @Transactional
    public UserResponseDto updateUser(UserUpdateDto userUpdateDto, UUID id) {
        UsersModel user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFound(id));

        userUpdateDto.name().ifPresent(user::setName);
        userUpdateDto.username().ifPresent(user::setUsername);
        userUpdateDto.email().ifPresent(user::setEmail);
        userUpdateDto.birthDate().ifPresent(user::setBirthDate);
        userUpdateDto.password().ifPresent(user::setPasswordHash);

        UsersModel updatedUser = userRepository.save(user);
        
        return new UserResponseDto(
                updatedUser.getId(),
                updatedUser.getName(),
                updatedUser.getUsername(),
                updatedUser.getEmail(),
                updatedUser.getBirthDate()
        );
    }

    public void deleteUser(UUID id) {
        UsersModel user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFound(id));

        userRepository.delete(user);
    }

}
