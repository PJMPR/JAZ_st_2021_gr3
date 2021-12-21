package com.example.demo.services;

import com.example.demo.contracts.LanguageDto;
import com.example.demo.model.Language;
import com.example.demo.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {
    final LanguageRepository languageRepository;

    public LanguageService(@Autowired LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<LanguageDto> getLanguages() {
        return languageRepository.findAll().stream().map(Language::to).toList();
    }
}
