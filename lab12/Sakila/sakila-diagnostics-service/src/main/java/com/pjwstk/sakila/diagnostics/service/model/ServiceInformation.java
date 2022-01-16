package com.pjwstk.sakila.diagnostics.service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ServiceInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String serviceName;
    private String host;
    private boolean isWorking;

    public ServiceInformation() {
    }

    public ServiceInformation(String serviceName, String host, boolean isWorking) {
        this.serviceName = serviceName;
        this.host = host;
        this.isWorking = isWorking;
    }

    public ServiceInformation(Long id, String serviceName, String host, boolean isWorking) {
        this.id = id;
        this.serviceName = serviceName;
        this.host = host;
        this.isWorking = isWorking;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String url) {
        this.host = url;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }
}
