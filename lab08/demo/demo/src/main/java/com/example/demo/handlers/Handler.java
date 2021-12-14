package com.example.demo.handlers;

import com.example.demo.contract.FilmDTO;

public abstract class Handler {
    private Handler next;

    public Handler linkWith(Handler next){
        this.next = next;
        return next;
    }

    public abstract boolean check(FilmDTO filmDTO);

    protected boolean checkNext(FilmDTO filmDTO){
        return next == null || next.check(filmDTO);
    }
}
