package com.example.movie_app.movies.repositories;

import com.example.movie_app.movies.DirectorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DirectorRepository extends JpaRepository<DirectorModel, UUID> {
}
