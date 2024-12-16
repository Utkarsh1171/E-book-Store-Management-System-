package com.example.demo.model;

import jakarta.xml.bind.annotation.XmlElement;

public class ServiceDetail {

    @XmlElement(name = "serviceName")
    private String serviceName;

    @XmlElement(name = "serviceDescription")
    private String serviceDescription;

    @XmlElement(name = "serviceRate")
    private String serviceRate;

    @XmlElement(name = "serviceRatePartAmount")
    private String serviceRatePartAmount;

    @XmlElement(name = "serviceRateLaborAmount")
    private String serviceRateLaborAmount;

    @XmlElement(name = "serviceIconId")
    private String serviceIconId;

    // Getters and setters...
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public String getServiceRate() {
        return serviceRate;
    }

    public void setServiceRate(String serviceRate) {
        this.serviceRate = serviceRate;
    }

    public String getServiceRatePartAmount() {
        return serviceRatePartAmount;
    }

    public void setServiceRatePartAmount(String serviceRatePartAmount) {
        this.serviceRatePartAmount = serviceRatePartAmount;
    }

    public String getServiceRateLaborAmount() {
        return serviceRateLaborAmount;
    }

    public void setServiceRateLaborAmount(String serviceRateLaborAmount) {
        this.serviceRateLaborAmount = serviceRateLaborAmount;
    }

    public String getServiceIconId() {
        return serviceIconId;
    }

    public void setServiceIconId(String serviceIconId) {
        this.serviceIconId = serviceIconId;
    }

}
