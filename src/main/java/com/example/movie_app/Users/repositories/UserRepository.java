package com.example.movie_app.Users.repositories;

import com.example.movie_app.Users.models.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UsersModel, UUID> {
    Optional<UsersModel> findByUsername(String username);
    Optional<UsersModel> findByEmail(String email);
}
