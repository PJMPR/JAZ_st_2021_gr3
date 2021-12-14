package com.example.demo.model.repos;

import com.example.demo.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepo extends JpaRepository<Language, Integer> {
    @Query("SELECT DISTINCT l.name FROM Language l")
    List<String> findAllDistinctLanguages();

    Language findByName(String name);
}