package com.example.movie_app.movies.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = "directors") @Table(name = "directors")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter @Setter

public class DirectorModel {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "directors", fetch = FetchType.LAZY)
    private Set<MovieModel> movies = new HashSet<>();

}
