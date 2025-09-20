package com.example.movie_app.movies.models;

import com.example.movie_app.Users.models.UsersModel;
import com.example.movie_app.review.models.ReviewModel;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "movies") @Table(name = "movies")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter @Setter

public class MovieModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String synopsis;
    private LocalDate releaseDate;
    private Integer durationInSeconds;
    private String imagePath;


    //Um filme só pode ter um único usuário
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // chave estrangeira
    private UsersModel user;

    //Um filme pode ter vários reviews
    @OneToMany(mappedBy = "movie")
    private Set<ReviewModel> reviews = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "movie_director",
            joinColumns = @JoinColumn(name = "movie_id"), //aqui define um nome para a coluna da tabela associativa
            inverseJoinColumns = @JoinColumn(name = "director_id")) //aqui define um nome para a coluna da tabela associativa
    private Set<DirectorModel> directors = new HashSet<>();
}
