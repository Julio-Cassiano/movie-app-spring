package com.example.movie_app.movies.repositories;

import com.example.movie_app.movies.models.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<MovieModel, Long> {
    @Query("SELECT DISTINCT m FROM movies m " +
            "LEFT JOIN FETCH m.user u " +
            "LEFT JOIN FETCH m.directors d")
    List<MovieModel> getAllMovies();
}
