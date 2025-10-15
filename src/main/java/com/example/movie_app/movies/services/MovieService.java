package com.example.movie_app.movies.services;

import com.example.movie_app.Users.exceptions.UserNotFound;
import com.example.movie_app.Users.models.UsersModel;
import com.example.movie_app.Users.repositories.UserRepository;
import com.example.movie_app.movies.dtos.MovieRecordDto;
import com.example.movie_app.movies.dtos.MovieResponseDto;
import com.example.movie_app.movies.models.DirectorModel;
import com.example.movie_app.movies.models.MovieModel;
import com.example.movie_app.movies.repositories.MovieRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final DirectorService directorService;

    @Transactional
    public MovieResponseDto addMovie(MovieRecordDto movieRecordDto) {
        UsersModel user = userRepository.findById(movieRecordDto.userId())
                .orElseThrow(() -> new UserNotFound(movieRecordDto.userId()));

        Set<DirectorModel> allDirectors = directorService.findOrCreateDirectors(movieRecordDto.directorNames());

        MovieModel movie = new MovieModel();
        movie.setName(movieRecordDto.name());
        movie.setSynopsis(movieRecordDto.synopsis());
        movie.setReleaseDate(movieRecordDto.releaseDate());
        movie.setDurationInSeconds(movieRecordDto.durationInSeconds());
        movie.setImagePath(movieRecordDto.imagePath());

        movie.setUser(user);
        movie.setDirectors(allDirectors);

        MovieModel savedMovie = movieRepository.save(movie);

        Set<String> savedDirectorNames = savedMovie.getDirectors().stream()
                .map(DirectorModel::getName)
                .collect(Collectors.toSet());

        return new MovieResponseDto(
                savedMovie.getId(),
                savedMovie.getName(),
                savedMovie.getSynopsis(),
                savedMovie.getReleaseDate(),
                savedMovie.getDurationInSeconds(),
                savedMovie.getImagePath(),
                savedMovie.getUser().getUsername(),
                savedDirectorNames
        );
    }

    public List<MovieResponseDto> getAllMovies(){
       List<MovieModel> movies = movieRepository.getAllMovies();

       return movies.stream().map(movie -> {
           Set<String> directors = movie.getDirectors().stream().map(
                   DirectorModel::getName).collect(Collectors.toSet());

           return new MovieResponseDto(
                   movie.getId(),
                   movie.getName(),
                   movie.getSynopsis(),
                   movie.getReleaseDate(),
                   movie.getDurationInSeconds(),
                   movie.getImagePath(),
                   movie.getUser().getUsername(),
                   directors
           );
       }).collect(Collectors.toList());
    }
}
