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
}
