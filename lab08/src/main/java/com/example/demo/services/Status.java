package com.example.demo.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Data
@Component
public class Status {
    @JsonIgnore
    private static final Status instance;

    static {
        instance = new Status();
    }

    private boolean isWorking;
    private Timestamp reloadStarted;
    private Timestamp reloadEnded;
    private Long moviesToUpdate;
    private Long progress;

    public synchronized static Status getInstance() {
        return instance;
    }

    public synchronized void setStartStatus() {
        Status.getInstance().setWorking(true);
        this.setReloadStarted(new Timestamp(new Date().getTime()));
    }

    public synchronized void setEndStatus() {
        this.setReloadEnded(new Timestamp(new Date().getTime()));
        this.setWorking(false);
    }

    public synchronized boolean isWorking() {
        return isWorking;
    }

    public synchronized void setWorking(boolean working) {
        isWorking = working;
    }

    public synchronized Timestamp getReloadStarted() {
        return reloadStarted;
    }

    public synchronized void setReloadStarted(Timestamp reloadStarted) {
        this.reloadStarted = reloadStarted;
    }

    public synchronized Timestamp getReloadEnded() {
        return reloadEnded;
    }

    public synchronized void setReloadEnded(Timestamp reloadEnded) {
        this.reloadEnded = reloadEnded;
    }

    public synchronized Long getMoviesToUpdate() {
        return moviesToUpdate;
    }

    public synchronized void setMoviesToUpdate(Long moviesToUpdate) {
        this.moviesToUpdate = moviesToUpdate;
    }

    public synchronized Long getProgress() {
        return progress;
    }

    public synchronized void setProgress(Long progress) {
        this.progress = progress;
    }
}