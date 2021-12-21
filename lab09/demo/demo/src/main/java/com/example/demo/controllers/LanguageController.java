package com.example.demo.controllers;

import com.example.demo.contracts.LanguageDto;
import com.example.demo.repositories.LanguageRepository;
import com.example.demo.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/languages")
public class LanguageController {
    final LanguageService languageService;

    public LanguageController(@Autowired LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping
    public ResponseEntity<List<LanguageDto>> getLanguages() {
        return ResponseEntity.ok(languageService.getLanguages());
    }
}
