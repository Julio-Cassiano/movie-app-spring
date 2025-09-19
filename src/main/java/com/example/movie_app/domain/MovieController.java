package com.example.movie_app.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Table(name = "movie")
@Entity(name = "movie")
@EqualsAndHashCode(of = "id")
public class MovieController {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
}
