package com.example.demo;

import com.example.demo.services.UpdaterJob;
import org.quartz.JobBuilder;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class WebClientConfiguration {

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() throws SchedulerException {
        var bean = new SchedulerFactoryBean();

        SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
        trigger.setJobDetail(job);
        trigger.setRepeatInterval(24 * 60 * 60);
        trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);

        bean.getScheduler().scheduleJob(JobBuilder
                .newJob()
                .ofType(UpdaterJob.class)
                .withIdentity("From schedule")
                .withDescription("With year 1980")
                .build(),
                (Trigger) trigger
        );

        return bean;
    }

    @Bean
    public WebClient webClient(){
        return WebClient.create("https://api.themoviedb.org/3");
    }
}
