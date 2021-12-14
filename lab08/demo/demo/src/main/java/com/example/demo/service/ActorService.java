package com.example.demo.service;

import com.example.demo.model.Actor;
import com.example.demo.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class ActorService {
    ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public boolean checkIfExist(String firstName, String lastName){
        Actor actor = actorRepository.findByFirstNameAndLastName(firstName, lastName);
        return actor == null;
    }

    public void addActor(String firstName, String lastName) {
        actorRepository.save(new Actor(firstName, lastName, new Timestamp(new Date().getTime())));
    }
}
