package com.example.demo.repositories;

import com.example.demo.contracts.FilmDto;
import com.example.demo.model.Film;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class FilmsRepository{
    private final int PAGE_CAPACITY = 30;
    private final EntityManager entityManager;


    public List<Film> executeQuery(String query, int skip) {
       return entityManager.createQuery(query,Film.class)
               .setFirstResult(skip)
               .setMaxResults(30)
               .getResultList();
    }
}
