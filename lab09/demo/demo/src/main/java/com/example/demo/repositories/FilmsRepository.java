package com.example.demo.repositories;

import com.example.demo.controllers.FilmParameterMap;
import com.example.demo.model.Film;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
@RequiredArgsConstructor
public class FilmsRepository {

    private final EntityManager entityManager;

    public void saveFilm(Film film) {
        entityManager.persist(film);
    }

    public void updateFilm(Film film) {
        entityManager.merge(film);
    }

    public void deleteFilm(Film film) {
        entityManager.remove(film);
    }

    public List<Film> getFilms() {
        return entityManager.createQuery("SELECT film FROM Film film", Film.class).setMaxResults(100).getResultList();
    }

    public List<Film> getFilms(FilmParameterMap<String> parameters) {
        final var where = parameters
                .entrySet()
                .stream()
                .map(e -> "%s = '%s'".formatted(e.getKey().trim(), e.getValue().trim()))
                .collect(Collectors.joining(" and "));

        final var query = "select film from Film film%s".formatted(where.isEmpty() ? "" : " where %s".formatted(where));

        return entityManager.createQuery(query, Film.class)
                .setFirstResult(parameters.getPageSize() * (parameters.getPage() - 1))
                .setMaxResults(parameters.getPageSize())
                .getResultList();
    }
}
