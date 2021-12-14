package com.example.demo.model.repos;

import com.example.demo.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepo extends JpaRepository<Film, Integer> {
}