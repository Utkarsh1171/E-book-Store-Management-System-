package com.example.JSON_To_POJO.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contractNumber;
    private String customerName;
    private String dealerId;
    private String dealerName;
    private String displayIcon;
    private String ppmClaimCatalogId;
    private String productName;
    private String planName;
    private String make;
    private String model;
    private String year;
    private String vin;
    private String webConId;
    private String serviceCount;
    private String uploadDocument;
    private String coverageCode;
    private String displayDisclaimer;
    private String productCode;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private List<AvailableService> availableServices;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private List<OpenClaim> openClaims;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private List<ServiceIcon> serviceIcons;

}
