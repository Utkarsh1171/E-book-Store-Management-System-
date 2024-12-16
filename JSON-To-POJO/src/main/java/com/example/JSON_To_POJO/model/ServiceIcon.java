package com.example.JSON_To_POJO.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ServiceIcon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ppmIntervalId;
    private String serviceOrderNumber;
    private String repairOrderNumber;
    private Integer serviceOdometer;  // Example: using Integer for numeric fields
    private Integer startOdometer;
    private Double reimbursementAmount;
    private Double reimbursementPartsAmount;
    private Double reimbursementLaborAmount;
    private Boolean redeemableFlag;
    private Boolean expiredFlag;
    private Boolean reimburseByInterval;
    private Boolean reimbursementByPartsAndLabor;
    private Double displayReimbursementAmount;
    private Boolean reimbursementPaid;
    private Boolean reimbursementForfeited;
    private Boolean sentReminder;
    private String coverageDescription;
    private String coverageName;
    private Double laborHours;
    private Double laborRate;
    private Double laborPartsCost;
    private Boolean isOptional;
    private String serviceDate;
    private Integer totalServiceCount;
    private Integer availableServiceCount;
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
    private Boolean isServiceNoteRequired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @OneToMany(mappedBy = "availableService")
    private List<AvailableService> serviceDetails;

}
