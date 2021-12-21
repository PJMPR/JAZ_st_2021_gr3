package com.example.demo.controllers;

import com.example.demo.contracts.LanguageDto;
import com.example.demo.repositories.LanguageRepository;
import com.example.demo.services.LanguageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/languages")
@AllArgsConstructor
public class LanguageController {
    private LanguageService languageService;

    @GetMapping
    public ResponseEntity getLanguages(){

        return ResponseEntity.ok(languageService.getAllLanguages());
    }
}
