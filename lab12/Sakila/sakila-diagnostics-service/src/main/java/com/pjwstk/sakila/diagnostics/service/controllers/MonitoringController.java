package com.pjwstk.sakila.diagnostics.service.controllers;

import com.pjwstk.sakila.diagnostics.service.monitor.ServiceData;
import com.pjwstk.sakila.diagnostics.service.model.ServiceInformation;
import com.pjwstk.sakila.diagnostics.service.repositories.MonitoringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("monitoring")
public class MonitoringController {

    @Autowired
    private MonitoringRepository repo;

    @PostMapping("register")
    public ResponseEntity<ServiceInformation> register(@RequestBody ServiceData serviceData) {
        return ResponseEntity.ok(
                repo.save(
                        new ServiceInformation(
                                1,
                                serviceData.getNameOfService(),
                                serviceData.getHostOfService(),
                                true)));
    }

    @GetMapping
    public ResponseEntity<List<ServiceInformation>> getServices() {
        return ResponseEntity.ok(
                repo.findAll());
    }
}