package com.example.movie_app.review.models;

import com.example.movie_app.movies.models.MovieModel;
import com.example.movie_app.Users.models.UsersModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "reviews")
@Table(name = "reviews")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter @Setter

public class ReviewModel {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String comment;
    @Min(0) @Max(5)
    private Short rating;

    //Varias reviews para um filmes
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id") // chave estrangeira
    private MovieModel movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UsersModel user;
}
