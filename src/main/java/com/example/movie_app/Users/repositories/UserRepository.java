package com.example.movie_app.Users.repositories;

import com.example.movie_app.Users.models.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UsersModel, UUID> {
}
