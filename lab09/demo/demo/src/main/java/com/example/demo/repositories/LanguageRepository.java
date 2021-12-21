package com.example.demo.repositories;

import com.example.demo.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language, Integer> {

    @Query(value = "SELECT language FROM Language language WHERE language.name=:name")
    public List<Language> findAllByName(String name);
}
