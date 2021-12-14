package com.example.demo.serviceAndRepo.Repositories;

import com.example.demo.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language,Integer> {

    @Query(value = "SELECT * FROM sakila.language WHERE name LIKE :name ",nativeQuery = true)
    Language findByName(String name);
}
