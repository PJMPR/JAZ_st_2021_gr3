package com.example.demo.services;

import com.example.demo.contracts.LanguageDto;
import com.example.demo.repositories.LanguageRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LanguageService {
    private LanguageRepository languageRepository;

    public List<LanguageDto> getAllLanguages() {
       return languageRepository.findAll().stream().map(language -> new LanguageDto(
                                            language.getLanguageId(),language.getName()))
                                            .collect(Collectors.toList());
    }

    public List<LanguageDto> getLanguagesBYName(String languageName) {
        return    languageRepository.findAllByName(languageName).stream()
                .map(language1 -> new LanguageDto(language1.getLanguageId(),language1.getName()))
                .collect(Collectors.toList());
    }
}
