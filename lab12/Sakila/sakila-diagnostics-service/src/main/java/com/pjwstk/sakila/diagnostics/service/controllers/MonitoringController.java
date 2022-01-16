package com.pjwstk.sakila.diagnostics.service.controllers;

import com.pjwstk.sakila.diagnostics.service.ReportService;
import com.pjwstk.sakila.diagnostics.service.model.ServiceInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MonitoringController {
    private final ReportService services;

    @GetMapping("/monitoring")
    public ResponseEntity<List<ServiceInformation>> getServiceStatus() {
        return ResponseEntity.ok(services.getServiceInformation());
    }

    @GetMapping("/monitoring/register")
    public ResponseEntity<ServiceInformation> updateServiceStatus1(@RequestParam("serviceName") String serviceName, @RequestParam("host") final String host) {
        return ResponseEntity.ok(services.updateServiceInformation(serviceName, host));
    }

}

