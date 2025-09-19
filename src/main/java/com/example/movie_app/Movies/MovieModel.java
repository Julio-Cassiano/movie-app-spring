package com.example.movie_app.Movies;

import com.example.movie_app.Users.UsersModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "movie")
@NoArgsConstructor
@Table(name = "movie")

public class MovieModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private Long id;
    @Getter @Setter private String name;
    @Getter @Setter private String synopsis;
    @Getter @Setter private String release_date;
    @Getter @Setter private Integer duration_in_minutes;

    //Um filme só pode ter um único usuário
    @ManyToOne
    @JoinColumn(name = "user_id") // chave estrangeira
    private UsersModel user;
}
