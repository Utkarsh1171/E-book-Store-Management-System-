package com.example.demo.model;

import jakarta.xml.bind.annotation.XmlElement;
import java.util.List;

public class OpenClaim {

    @XmlElement(name = "item")
    private List<ServiceItem> item;

    // Getters and setters...
    public List<ServiceItem> getItem() {
        return item;
    }

    public void setItem(List<ServiceItem> item) {
        this.item = item;
    }

}
