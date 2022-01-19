package com.pjwstk.sakila.diagnostics.service.quartz;

import com.pjwstk.sakila.diagnostics.service.monitor.ServiceData;
import com.pjwstk.sakila.diagnostics.service.repositories.MonitoringRepository;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ServiceChecker implements Job {

    @Autowired
    private MonitoringRepository repo;

    public void execute(JobExecutionContext context) throws JobExecutionException {

    }

    private void checkService(ServiceData service) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.getForEntity(
                service.getHostOfService() +
                "/diagnostics/status",
                String.class);

        if (response.getStatusCodeValue() == 200) System.out.println(service.getNameOfService() + " is working");
        else System.out.println(service.getNameOfService() + " is not working");
    }
}