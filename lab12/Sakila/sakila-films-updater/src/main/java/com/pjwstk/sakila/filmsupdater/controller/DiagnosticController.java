package com.pjwstk.sakila.filmsupdater.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("diagnostics")
public class DiagnosticController {
    @Value("${sakila.diagnostics.service.name}")
    String serviceName;
    @Value("${sakila.diagnostics.service.host}")
    String host;

    @PostMapping()
    public ResponseEntity getDiagnostics() {
        return new ResponseEntity(List.of(serviceName,host), HttpStatus.OK);
    }

    @PostConstruct
    public void init() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate.getForEntity(String.format("http://localhost:8083/monitoring/register?serviceName="+serviceName+"&host="+host), String.class);
        } catch (Exception e) {
            System.out.println("Cannot register service");
        }
    }
}
