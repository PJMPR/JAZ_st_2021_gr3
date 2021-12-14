package com.example.demo.services.handlers;

import com.example.demo.controllers.DTO.FilmDTO;
import com.example.demo.services.ActorService;


public class ActorsHandler extends Handler {
    ActorService actorService;

    public ActorsHandler(ActorService actorService) {
        this.actorService = actorService;
    }

    @Override
    public boolean check(FilmDTO filmDTO) {
        if (filmDTO.getFilmActors() != null) {
            for (String actor : filmDTO.getFilmActors()) {
                String[] names = actor.split(" ");
                if (actorService.checkIfExist(names[0], names[1])) {
                    actorService.addActor(names[0], names[1]);
                }
            }
        }
        return checkNext(filmDTO);
    }
}