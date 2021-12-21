package com.example.demo.services;

import com.example.demo.contracts.LanguageDto;
import com.example.demo.repositories.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LanguagesService {
    private final LanguageRepository languageRepository;

    public List<LanguageDto> getLanguages() {
        return languageRepository.findAll().stream().map(language -> new LanguageDto(language.getLanguageId(), language.getName())).collect(Collectors.toList());
    }

}
