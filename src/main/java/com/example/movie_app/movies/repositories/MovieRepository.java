package com.example.movie_app.movies.repositories;

import com.example.movie_app.movies.models.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<MovieModel, Long> {
    @Query("SELECT DISTINCT m FROM movies m " +
            "LEFT JOIN FETCH m.user u " +
            "LEFT JOIN FETCH m.directors d")
    List<MovieModel> getAllMovies();

    @Query("SELECT DISTINCT m FROM movies m " +
            "LEFT JOIN FETCH m.user u " +
            "LEFT JOIN FETCH m.directors d " +
            "WHERE m.id = :id")
    Optional<MovieModel> findById(Long id);
}
