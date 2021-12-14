package com.example.demo.service;

import com.example.demo.SystemStatus;
import com.example.demo.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Service
public class FilmService {
    RestTemplate rest;
    ActorRepository actorRepository;
    private static Logger LOGGER = Logger.getLogger(String.valueOf(FilmService.class));
    FileHandler toHandle;

    @Autowired
    public FilmService(RestTemplate rest, ActorRepository actorRepository, SystemStatus systemStatusInfo, ScheduleService scheduler) throws IOException {
        SimpleFormatter formatter = new SimpleFormatter();
        toHandle = new FileHandler("Log.txt", true);
        LOGGER.addHandler(toHandle);
        toHandle.setFormatter(formatter);

        this.rest = rest;
        this.actorRepository = actorRepository;
    }

    public void Update(int year){
        //mialem male problemy ,, //do napisania
    }



}
