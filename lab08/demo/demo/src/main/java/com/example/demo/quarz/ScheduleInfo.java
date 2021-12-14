package com.example.demo.quarz;

import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
@Configuration
public class ScheduleInfo implements Serializable {
    private int Count;
    private boolean runForever;
    private int repeatIntervalHs;
    private int hourStarted;

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        this.Count = count;
    }

    public boolean isRunForever() {
        return runForever;
    }

    public void setRunForever(boolean runForever) {
        this.runForever = runForever;
    }

    public int getRepeatIntervalHs() {
        return repeatIntervalHs;
    }

    public void setRepeatIntervalHs(int repeatIntervalHs) {
        this.repeatIntervalHs = repeatIntervalHs;
    }

    public int getHourStarted() {
        return hourStarted;
    }

    public void setHourStarted(int hourStarted) {
        this.hourStarted = hourStarted;
    }
}