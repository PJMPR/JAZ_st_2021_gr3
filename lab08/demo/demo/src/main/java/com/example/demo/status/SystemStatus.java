package com.example.demo.status;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

@Component
public class SystemStatus {
    boolean isWorking;
    Timestamp reloadStarted;
    Timestamp reloadEnded;
    int moviesToUptade;
    int progress;
    ArrayList<ProccessStatus> stepsFinished;

    @JsonIgnore
    private static final SystemStatus instance;
    static {
        instance = new SystemStatus();
    }

    public static SystemStatus getInstance(){
        return instance;
    }

    public void setStartStatus(){
        SystemStatus.getInstance().setWorking(true);
        this.setReloadStarted(new Timestamp(new Date().getTime()));
    }

    public void setEndStatus(){
        this.setReloadEnded(new Timestamp(new Date().getTime()));
        this.setWorking(false);
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public Date getReloadStarted() {
        return reloadStarted;
    }

    public void setReloadStarted(Timestamp reloadStarted) {
        this.reloadStarted = reloadStarted;
    }

    public Date getReloadEnded() {
        return reloadEnded;
    }

    public void setReloadEnded(Timestamp reloadEnded) {
        this.reloadEnded = reloadEnded;
    }

    public int getMoviesToUptade() {
        return moviesToUptade;
    }

    public void setMoviesToUptade(int moviesToUptade) {
        this.moviesToUptade = moviesToUptade;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public ArrayList<ProccessStatus> getStepsFinished() {
        return stepsFinished;
    }

    public void setStepsFinished(ArrayList<ProccessStatus> stepsFinished) {
        this.stepsFinished = stepsFinished;
    }
}
