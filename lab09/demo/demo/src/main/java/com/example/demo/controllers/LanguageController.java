package com.example.demo.controllers;

import com.example.demo.services.LanguagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/languages")
public class LanguageController {
    private final LanguagesService languagesService;

    @GetMapping
    public ResponseEntity getLanguages(){
        return ResponseEntity.ok(languagesService.getLanguages());
    }
}
