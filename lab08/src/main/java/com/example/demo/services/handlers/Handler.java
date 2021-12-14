package com.example.demo.services.handlers;

import com.example.demo.controllers.DTO.FilmDTO;
import org.springframework.stereotype.Component;

@Component
public abstract class Handler {
    private Handler next;

    public Handler linkWith(Handler next) {
        this.next = next;
        return next;
    }

    public abstract boolean check(FilmDTO filmDTO);

    protected boolean checkNext(FilmDTO filmDTO) {
        return next == null || next.check(filmDTO);
    }
}