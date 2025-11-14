package com.example.movie_app.movies.services;

import com.example.movie_app.Users.exceptions.UserNotFound;
import com.example.movie_app.Users.exceptions.UsernameNotFound;
import com.example.movie_app.Users.models.UsersModel;
import com.example.movie_app.Users.repositories.UserRepository;
import com.example.movie_app.movies.dtos.MovieRecordDto;
import com.example.movie_app.movies.dtos.MovieResponseDto;
import com.example.movie_app.movies.dtos.MovieUpdateDto;
import com.example.movie_app.movies.exceptions.MovieNotFound;
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
        UsersModel user = userRepository.findByUsername(movieRecordDto.username())
                .orElseThrow(() -> new UsernameNotFound(movieRecordDto.username()));

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

    public MovieResponseDto getMovieById(Long id){
       MovieModel movie = movieRepository.findById(id).orElseThrow(
               () -> new MovieNotFound(id));

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
    }

    @Transactional
    public MovieResponseDto updateMovie(MovieUpdateDto movieUpdateDto, Long id) {
        MovieModel movie = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFound(id));

        if(movieUpdateDto.name() != null && !movieUpdateDto.name().isEmpty()){
            movie.setName(movieUpdateDto.name());
        }

        if(movieUpdateDto.synopsis() != null && !movieUpdateDto.synopsis().isEmpty()){
            movie.setSynopsis(movieUpdateDto.synopsis());
        }

        if(movieUpdateDto.releaseDate() != null){
            movie.setReleaseDate(movieUpdateDto.releaseDate());
        }

        if(movieUpdateDto.durationInSeconds() != null){
            movie.setDurationInSeconds(movieUpdateDto.durationInSeconds());
        }

        if(movieUpdateDto.imagePath() != null && !movieUpdateDto.imagePath().isEmpty()){
            movie.setImagePath(movieUpdateDto.imagePath());
        }

        if(movieUpdateDto.directorNames() != null && !movieUpdateDto.directorNames().isEmpty()){
            Set<DirectorModel> allDirectors = directorService.findOrCreateDirectors(movieUpdateDto.directorNames());
            movie.setDirectors(allDirectors);
        }

        MovieModel savedMovie = movieRepository.save(movie);
        return new MovieResponseDto(
                savedMovie.getId(),
                savedMovie.getName(),
                savedMovie.getSynopsis(),
                savedMovie.getReleaseDate(),
                savedMovie.getDurationInSeconds(),
                savedMovie.getImagePath(),
                savedMovie.getUser().getUsername(),
                savedMovie.getDirectors().stream().map(DirectorModel::getName).collect(Collectors.toSet())
        );
    }

    public void deleteMovie(Long id){
        MovieModel movie = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFound(id));

        movieRepository.delete(movie);
    }
}
