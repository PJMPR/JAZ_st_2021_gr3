package com.example.demo.repository;

import com.example.demo.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmActorsRepository extends JpaRepository<Film, Integer> {
    Film findByFirstNameAndLastName(String firstName, String LastName);
}
