package com.example.demo.repositories;

import com.example.demo.model.Language;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class LanguageRepository {
    private final EntityManager entityManager;

    public List<Language> findAll() {
        return entityManager.createQuery("select l from Language l", Language.class).getResultList();
    }
}
