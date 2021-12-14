package com.example.demo.services;

import com.example.demo.model.Language;
import com.example.demo.model.repos.LanguageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class LanguageService {
    LanguageRepo languageRepo;

    @Autowired
    public LanguageService(LanguageRepo languageRepo) {
        this.languageRepo = languageRepo;
    }

    public List<String> getAllLanguages() {
        return languageRepo.findAllDistinctLanguages();
    }

    public void addLanguage(String language) {
        languageRepo.save(new Language(language, new Timestamp(new Date().getTime())));
    }

    public Language getLanguage(String language) {
        return languageRepo.findByName(language);
    }
}