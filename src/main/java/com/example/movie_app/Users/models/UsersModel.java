package com.example.movie_app.Users.models;

import com.example.movie_app.movies.models.MovieModel;
import com.example.movie_app.review.models.ReviewModel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = "users")
@NoArgsConstructor
@Table(name = "users")
@EqualsAndHashCode(of = "id")
@Getter @Setter
public class UsersModel {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    private LocalDate birthDate;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String email;
    private String passwordHash;
    //Um usuário pode ter vários filmes
    @OneToMany(mappedBy = "user")
    private Set<MovieModel> movies = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<ReviewModel> reviews = new HashSet<>();
}
