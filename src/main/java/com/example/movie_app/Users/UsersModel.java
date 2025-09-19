package com.example.movie_app.Users;

import com.example.movie_app.Movies.MovieModel;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "user")
@NoArgsConstructor
@Table(name = "user")
@EqualsAndHashCode(of = "id")

public class UsersModel {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    private String id;
    @Getter @Setter private String name;
    @Getter @Setter private String birth_date;
    @Getter @Setter private String user_name;
    @Getter @Setter private String email;
    @Getter @Setter private String password_hash;
    //Um usuário pode ter vários filmes
    @OneToMany(mappedBy = "user")
    private List<MovieModel> movies;
}
