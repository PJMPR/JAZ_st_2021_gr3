package com.example.demo.services;

import com.example.demo.repositories.BulkRepository;
import com.example.demo.services.tasks.Task;
import org.quartz.JobBuilder;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Arrays;
import java.util.Optional;

@Service
public class Updater {
    Logger logger = LoggerFactory.getLogger(getClass());
    private final UpdaterStatus currentStatus = new UpdaterStatus();
    private final ExternalAPIFetcher fetcher;
    private final BulkRepository repository;


    public Updater(@Autowired ExternalAPIFetcher fetcher, @Autowired BulkRepository repository) {
        this.fetcher = fetcher;
        this.repository = repository;
    }

    public void start(Optional<Integer> year) throws SchedulerException {
        if (currentStatus.isRunning()) return;
        currentStatus.setRunning(true);
        currentStatus.setReloadStarted(Timestamp.from(Instant.now()));

        Arrays.stream(Task.values()).forEach(task -> task.execute(fetcher, repository));

        currentStatus.setReloadEnded(Timestamp.from(Instant.now()));
        currentStatus.setRunning(false);

        logger.info("Task finished %s".formatted(currentStatus));
    }

    public UpdaterStatus getStatus() {
        return currentStatus;
    }
}
