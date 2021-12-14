package com.example.demo.quarz;

import org.quartz.*;

import static org.quartz.DateBuilder.dateOf;

public class TimerUtil {
    private TimerUtil(){}

    public static JobDetail buildJobDetail(final Class jobClass, final ScheduleInfo info){
        final JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put(jobClass.getSimpleName(), info);

        return JobBuilder
                .newJob(jobClass)
                .withIdentity(jobClass.getSimpleName())
                .setJobData(jobDataMap).build();
    }

    public static Trigger buildTrigger(final Class jobClass, final ScheduleInfo info){
        SimpleScheduleBuilder builder = SimpleScheduleBuilder.simpleSchedule().withIntervalInHours(info.getRepeatIntervalHs());

        if(info.isRunForever()){
            builder = builder.repeatForever();
        }else {
            builder = builder.withRepeatCount(info.getCount() - 1);
        }

        return TriggerBuilder
                .newTrigger()
                .withIdentity(jobClass.getSimpleName())
                .withSchedule(builder)
                .startAt(dateOf(info.getHourStarted(), 0, 0)).build();
    }
}