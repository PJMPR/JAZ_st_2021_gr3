package com.example.demo.services;

import com.example.demo.model.Actor;
import com.example.demo.model.repos.ActorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class ActorService {
    ActorRepo actorRepo;

    @Autowired
    public ActorService(ActorRepo actorRepo) {
        this.actorRepo = actorRepo;
    }

    public boolean checkIfExist(String firstName, String lastName) {
        Actor actor = actorRepo.findByFirstNameAndLastName(firstName, lastName);
        return actor == null;
    }

    public void addActor(String firstName, String lastName) {
        actorRepo.save(new Actor(firstName, lastName, new Timestamp(new Date().getTime())));
    }
}