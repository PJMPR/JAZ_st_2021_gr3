package com.example.demo.services.handlers;

import com.example.demo.controllers.DTO.FilmDTO;
import com.example.demo.services.LanguageService;

import java.util.List;

public class LanguageHandler extends Handler {
    LanguageService languageService;

    public LanguageHandler(LanguageService languageService) {
        this.languageService = languageService;
    }

    @Override
    public boolean check(FilmDTO filmDTO) {
        if (filmDTO.getLanguage() != null) {
            List<String> languages = languageService.getAllLanguages();
            for (String language : filmDTO.getLanguage()) {
                if (languages.stream().noneMatch(s -> s.equalsIgnoreCase(language))) {
                    languageService.addLanguage(language);
                }
            }
        }
        return checkNext(filmDTO);
    }
}