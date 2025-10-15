package com.example.movie_app.movies.services;

import com.example.movie_app.movies.models.DirectorModel;
import com.example.movie_app.movies.repositories.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DirectorService {
    private final DirectorRepository directorRepository;

    public Set<DirectorModel> findOrCreateDirectors(Set<String> directorNames) {
        if (directorNames == null || directorNames.isEmpty()) {
            return new HashSet<>();
        }

        //busca todos os diretores em uma unica query
        List<DirectorModel> existingDirectors = directorRepository.findByNameIn(directorNames);
        Set<String> existingDirectorsNames = existingDirectors.stream()
                .map(DirectorModel::getName)
                .collect(Collectors.toSet());

        //Determina quais diretores são novos
        List<DirectorModel> newDirectors = directorNames.stream()
                .filter(name -> !existingDirectorsNames.contains(name))
                .map(name -> {
                    DirectorModel newDirector = new DirectorModel();
                    newDirector.setName(name);
                    return newDirector;
                }).toList();

        if (!newDirectors.isEmpty()) {
            newDirectors = directorRepository.saveAll(newDirectors);
        }

        Set<DirectorModel> allDirectors = new HashSet<>(existingDirectors);
        allDirectors.addAll(newDirectors);

        return allDirectors;
    };
}
