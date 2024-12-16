package com.example.demo.model;

import jakarta.xml.bind.annotation.XmlElement;
import java.util.List;

public class Service {

    private String ppmIntervalId;
    private String serviceOrderNumber;
    // Other fields...

    @XmlElement(name = "serviceDetails")
    private List<ServiceDetail> serviceDetails;

    // Getters and setters...
    public String getPpmIntervalId() {
        return ppmIntervalId;
    }

    public void setPpmIntervalId(String ppmIntervalId) {
        this.ppmIntervalId = ppmIntervalId;
    }

    public String getServiceOrderNumber() {
        return serviceOrderNumber;
    }

    public void setServiceOrderNumber(String serviceOrderNumber) {
        this.serviceOrderNumber = serviceOrderNumber;
    }

    public List<ServiceDetail> getServiceDetails() {
        return serviceDetails;
    }

    public void setServiceDetails(List<ServiceDetail> serviceDetails) {
        this.serviceDetails = serviceDetails;
    }

}
