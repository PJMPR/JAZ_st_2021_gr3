package com.example.demo.service;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ScheduleService {
    private static Logger LOGGER = Logger.getLogger(String.valueOf(ScheduleService.class));
    private final Scheduler scheduler;

    @Autowired
    public ScheduleService() throws SchedulerException {
        this.scheduler = new StdSchedulerFactory().getScheduler();
    }

}
