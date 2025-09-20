package com.example.movie_app.Movies;

import com.example.movie_app.Users.UsersModel;
import com.example.movie_app.review.ReviewModel;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "movies") @Table(name = "movies")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter @Setter
public class MovieModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String synopsis;
    private LocalDate release_date;
    private Integer duration_in_seconds;

    //Um filme só pode ter um único usuário
    @ManyToOne
    @JoinColumn(name = "user_id") // chave estrangeira
    private UsersModel user;

    //Um filme pode ter vários reviews
    @OneToMany(mappedBy = "movie")
    private Set<ReviewModel> reviews = new HashSet<>();
}
