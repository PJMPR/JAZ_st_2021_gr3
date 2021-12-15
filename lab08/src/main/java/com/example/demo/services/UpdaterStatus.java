package com.example.demo.services;

import com.example.demo.services.tasks.Task;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UpdaterStatus {
    private boolean running = false;
    private Timestamp reloadStarted;
    private Timestamp reloadEnded;

    private final List<Task> tasksFinished = new ArrayList<>();

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public List<Task> getTasksFinished() {
        return tasksFinished;
    }

    public Timestamp getReloadStarted() {
        return reloadStarted;
    }

    public void setReloadStarted(Timestamp reloadStarted) {
        this.reloadStarted = reloadStarted;
    }

    public Timestamp getReloadEnded() {
        return reloadEnded;
    }

    public void setReloadEnded(Timestamp reloadEnded) {
        this.reloadEnded = reloadEnded;
    }
}
