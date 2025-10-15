package com.example.movie_app.movies.repositories;

import com.example.movie_app.movies.models.DirectorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface DirectorRepository extends JpaRepository<DirectorModel, UUID> {

    // Este metodo buscará um diretor pelo nome.
    // Usamos Optional porque o diretor pode não existir.
    Optional<DirectorModel> findByName(String name);
    List<DirectorModel> findByNameIn(Set<String> names);
}
