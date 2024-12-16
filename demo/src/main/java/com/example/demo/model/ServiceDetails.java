/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model;

import jakarta.xml.bind.annotation.XmlElement;
import java.util.List;

public class ServiceDetails {

    @XmlElement(name = "item")
    private List<ServiceDetail> item;

    // Getters and setters...
    public List<ServiceDetail> getItem() {
        return item;
    }

    public void setItem(List<ServiceDetail> item) {
        this.item = item;
    }

}
