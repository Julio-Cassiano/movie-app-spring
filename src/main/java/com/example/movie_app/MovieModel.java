package com.example.movie_app;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "movie")
public class MovieModel {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Getter private String id;
    @Getter @Setter private String name;
    @Getter @Setter private String synopsis;
    @Getter @Setter private String release_date;
    @Getter @Setter private Integer duration_in_minutes;

}
