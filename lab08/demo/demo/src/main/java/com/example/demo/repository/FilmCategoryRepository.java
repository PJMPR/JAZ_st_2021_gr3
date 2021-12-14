package com.example.demo.repository;

import com.example.demo.model.FilmCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmCategoryRepository extends JpaRepository<FilmCategory, Integer> {
    FilmCategory findByFirstNameAndLastName(String firstName, String LastName);
}
