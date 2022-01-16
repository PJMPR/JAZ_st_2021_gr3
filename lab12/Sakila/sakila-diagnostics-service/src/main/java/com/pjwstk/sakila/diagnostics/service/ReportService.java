package com.pjwstk.sakila.diagnostics.service;

import com.pjwstk.sakila.diagnostics.service.model.ServiceInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportRepository repository;

    public List<ServiceInformation> getServiceInformation() {
        return repository.findAll();
    }

    public ServiceInformation updateServiceInformation(String serviceName, String host) {
        return repository.save(new ServiceInformation(1L,serviceName,host,true));
    }
}
