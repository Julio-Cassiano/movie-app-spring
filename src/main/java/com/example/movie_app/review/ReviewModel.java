package com.example.movie_app.review;

import com.example.movie_app.Movies.MovieModel;
import com.example.movie_app.Users.UsersModel;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "reviews")
@Table(name = "reviews")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter @Setter
public class ReviewModel {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String comment;

    //Varias reviews para um filmes
    @ManyToOne
    @JoinColumn(name = "movie_id") // chave estrangeira
    private MovieModel movie;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersModel user;
}
