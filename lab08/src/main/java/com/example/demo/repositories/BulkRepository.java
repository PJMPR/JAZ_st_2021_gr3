package com.example.demo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public record BulkRepository(ActorRepository actorRepository,
                             CategoryRepository categoryRepository,
                             FilmRepository filmRepository,
                             LanguageRepository languageRepository) {
    public BulkRepository(@Autowired ActorRepository actorRepository, @Autowired CategoryRepository categoryRepository, @Autowired FilmRepository filmRepository, @Autowired LanguageRepository languageRepository) {
        this.actorRepository = actorRepository;
        this.categoryRepository = categoryRepository;
        this.filmRepository = filmRepository;
        this.languageRepository = languageRepository;
    }
}
