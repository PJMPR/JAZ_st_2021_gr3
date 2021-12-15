package com.example.demo.services;

import org.quartz.JobExecutionContext;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdaterJob extends QuartzJobBean {
    Logger logger = LoggerFactory.getLogger(getClass());

    private final Updater updater;

    public UpdaterJob(@Autowired Updater updater) {
        this.updater = updater;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) {
        logger.info("Job ** {} ** fired @ {}", context.getJobDetail().getKey().getName(), context.getFireTime());
        try {
            updater.start(Optional.empty());
        } catch (SchedulerException e) {
            logger.error(e.toString());
        }
        logger.info("Next job scheduled @ {}", context.getNextFireTime());
    }
}
