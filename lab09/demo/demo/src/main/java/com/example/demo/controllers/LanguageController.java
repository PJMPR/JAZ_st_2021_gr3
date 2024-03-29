package com.example.demo.controllers;

import com.example.demo.contracts.LanguageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/languages")
public class LanguageController {

    @GetMapping
    public ResponseEntity getLanguages(){

        return ResponseEntity.ok(List.of(
                new LanguageDto(1,"polish"),
                new LanguageDto(1,"english"),
                new LanguageDto(1,"french"),
                new LanguageDto(1,"german")
        ));
    }
}
