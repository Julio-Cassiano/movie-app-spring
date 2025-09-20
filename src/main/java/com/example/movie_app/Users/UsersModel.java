package com.example.movie_app.Users;

import com.example.movie_app.movies.MovieModel;
import com.example.movie_app.review.ReviewModel;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "users")
@NoArgsConstructor
@Table(name = "users")
@EqualsAndHashCode(of = "id")
@Getter @Setter

public class UsersModel {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    private LocalDate birth_date;
    @Column(nullable = false)
    private String username;
    private String email;
    private String password_hash;
    //Um usuário pode ter vários filmes
    @OneToMany(mappedBy = "user")
    private Set<MovieModel> movies = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<ReviewModel> reviews = new HashSet<>();
}
