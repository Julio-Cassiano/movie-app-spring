package com.example.movie_app.movies.repositories;

import com.example.movie_app.movies.models.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieModel, Long> {
}
