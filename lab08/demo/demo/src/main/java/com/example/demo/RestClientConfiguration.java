package com.example.demo;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestClientConfiguration {

    @Bean
    public RestTemplate restTemplate(){
        RestTemplateBuilder builder = new RestTemplateBuilder();
        return builder.build();
    }
}
