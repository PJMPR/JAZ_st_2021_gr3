package com.example.demo.controllers;

import com.example.demo.services.Updater;
import com.example.demo.services.UpdaterJob;
import com.example.demo.services.UpdaterStatus;
import org.quartz.JobBuilder;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

@Controller
@RequestMapping("updater")
public class UpdaterController {
    final Updater updater;
    private final SchedulerFactoryBean scheduler;

    public UpdaterController(@Autowired Updater updater, @Autowired SchedulerFactoryBean scheduler) {
        this.updater = updater;
        this.scheduler = scheduler;
    }

    @GetMapping("reload")
    public ResponseEntity<Timestamp> doReload(@RequestParam final Optional<Integer> year) throws SchedulerException {
        scheduler.getScheduler().addJob(JobBuilder
                        .newJob()
                        .ofType(UpdaterJob.class)
                        .withIdentity("At request")
                        .withDescription("With year %d".formatted(year.orElse(1980)))
                        .build(),
                true
        );
        return ResponseEntity.ok(Timestamp.from(Instant.now()));
    }

    @GetMapping("status")
    public ResponseEntity<UpdaterStatus> getStatus() {
        return ResponseEntity.ok(updater.getStatus());
    }
}
