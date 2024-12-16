package com.example.JSON_To_POJO.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class OpenClaim {

    // Similar fields as AvailableService
    // Add @ManyToOne relationship with Contract
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ppmIntervalId;
    private String serviceOrderNumber;
    private String repairOrderNumber;
    private String serviceOdometer;
    private String startOdometer;
    private String reimbursementAmount;
    private String reimbursementPartsAmount;
    private String reimbursementLaborAmount;
    private String redeemableFlag;
    private String expiredFlag;
    private String reimburseByInterval;
    private String reimbursementByPartsAndLabor;
    private String displayReimbursementAmount;
    private String reimbursementPaid;
    private String reimbursementForfeited;
    private String sentReminder;
    private String coverageDescription;
    private String coverageName;
    private String laborHours;
    private String laborRate;
    private String laborPartsCost;
    private String isOptional;
    private String serviceDate;
    private String totalServiceCount;
    private String availableServiceCount;
    private String serviceAvailableMessage;
    private String productPlanCoverageId;
    private String ppmServiceCatalogId;
    private String submittedBy;
    private String claimNumber;
    private String claimStatus;
    private String claimDealerId;
    private String claimDealerName;
    private String paymentDate;
    private String serviceSubcostList;
    private String productCodePriority;
    private String serviceNotes;
    private String programCoverageId;
    private String isServiceNoteRequired;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

// Example in OpenClaim class
    @OneToMany(mappedBy = "openClaim") // 'openClaim' should match the exact field name in AvailableService
    private List<AvailableService> serviceDetails;

}
