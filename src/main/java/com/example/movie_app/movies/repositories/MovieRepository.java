package com.example.movie_app.movies.repositories;

import com.example.movie_app.movies.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieModel, Long> {
}
