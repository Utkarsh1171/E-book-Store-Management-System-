package com.example.JSON_To_POJO.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ServiceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;
    private String serviceDescription;
    private String serviceRate;
    private String serviceRatePartAmount;
    private String serviceRateLaborAmount;
    private String serviceIconId;

    @ManyToOne
    @JoinColumn(name = "available_service_id")
    private AvailableService availableService;

}
