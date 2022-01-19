package com.pjwstk.sakila.diagnostics.service.monitor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Configuration
class Registerer {
    String nameOfService;
    String hostOfService;

    public Registerer(@Value("${sakila.diagnostics.service.name}") String nameOfService,
                      @Value("${sakila.diagnostics.service.host}") String hostOfService) {
        this.nameOfService = nameOfService;
        this.hostOfService = hostOfService;
    }

    @PostConstruct
    public void postConstruct() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ServiceData> entity =
                new HttpEntity<ServiceData>(
                    new ServiceData(
                            nameOfService,
                            hostOfService),
                    headers);

        ResponseEntity response = restTemplate.exchange(
                "http://localhost:8083/monitoring/register",
                HttpMethod.POST,
                entity,
                ServiceData.class);
    }
}