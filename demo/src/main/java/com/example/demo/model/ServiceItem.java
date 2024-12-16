package com.example.demo.model;

import jakarta.xml.bind.annotation.XmlElement;

public class ServiceItem {

    @XmlElement(name = "ppmIntervalId")
    private String ppmIntervalId;

    @XmlElement(name = "serviceOrderNumber")
    private String serviceOrderNumber;

    @XmlElement(name = "repairOrderNumber")
    private String repairOrderNumber;

    @XmlElement(name = "serviceOdometer")
    private String serviceOdometer;

    @XmlElement(name = "startOdometer")
    private String startOdometer;

    @XmlElement(name = "reimbursementAmount")
    private String reimbursementAmount;

    @XmlElement(name = "reimbursementPartsAmount")
    private String reimbursementPartsAmount;

    @XmlElement(name = "reimbursementLaborAmount")
    private String reimbursementLaborAmount;

    @XmlElement(name = "redeemableFlag")
    private String redeemableFlag;

    @XmlElement(name = "expiredFlag")
    private String expiredFlag;

    @XmlElement(name = "reimburseByInterval")
    private String reimburseByInterval;

    @XmlElement(name = "reimbursementByPartsAndLabor")
    private String reimbursementByPartsAndLabor;

    @XmlElement(name = "displayReimbursementAmount")
    private String displayReimbursementAmount;

    @XmlElement(name = "reimbursementPaid")
    private String reimbursementPaid;

    @XmlElement(name = "reimbursementForfeited")
    private String reimbursementForfeited;

    @XmlElement(name = "sentReminder")
    private String sentReminder;

    @XmlElement(name = "coverageDescription")
    private String coverageDescription;

    @XmlElement(name = "coverageName")
    private String coverageName;

    @XmlElement(name = "laborHours")
    private String laborHours;

    @XmlElement(name = "laborRate")
    private String laborRate;

    @XmlElement(name = "laborPartsCost")
    private String laborPartsCost;

    @XmlElement(name = "isOptional")
    private String isOptional;

    @XmlElement(name = "serviceDate")
    private String serviceDate;

    @XmlElement(name = "totalServiceCount")
    private String totalServiceCount;

    @XmlElement(name = "availableServiceCount")
    private String availableServiceCount;

    @XmlElement(name = "serviceAvailableMessage")
    private String serviceAvailableMessage;

    @XmlElement(name = "productPlanCoverageId")
    private String productPlanCoverageId;

    @XmlElement(name = "ppmServiceCatalogId")
    private String ppmServiceCatalogId;

    @XmlElement(name = "submittedBy")
    private String submittedBy;

    @XmlElement(name = "claimNumber")
    private String claimNumber;

    @XmlElement(name = "claimStatus")
    private String claimStatus;

    @XmlElement(name = "claimDealerId")
    private String claimDealerId;

    @XmlElement(name = "claimDealerName")
    private String claimDealerName;

    @XmlElement(name = "paymentDate")
    private String paymentDate;

    @XmlElement(name = "serviceSubcostList")
    private String serviceSubcostList;

    @XmlElement(name = "productCodePriority")
    private String productCodePriority;

    @XmlElement(name = "serviceNotes")
    private String serviceNotes;

    @XmlElement(name = "programCoverageId")
    private String programCoverageId;

    @XmlElement(name = "isServiceNoteRequired")
    private String isServiceNoteRequired;

    @XmlElement(name = "serviceDetails")
    private ServiceDetails serviceDetails;

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

    public String getRepairOrderNumber() {
        return repairOrderNumber;
    }

    public void setRepairOrderNumber(String repairOrderNumber) {
        this.repairOrderNumber = repairOrderNumber;
    }

    public String getServiceOdometer() {
        return serviceOdometer;
    }

    public void setServiceOdometer(String serviceOdometer) {
        this.serviceOdometer = serviceOdometer;
    }

    public String getStartOdometer() {
        return startOdometer;
    }

    public void setStartOdometer(String startOdometer) {
        this.startOdometer = startOdometer;
    }

    public String getReimbursementAmount() {
        return reimbursementAmount;
    }

    public void setReimbursementAmount(String reimbursementAmount) {
        this.reimbursementAmount = reimbursementAmount;
    }

    public String getReimbursementPartsAmount() {
        return reimbursementPartsAmount;
    }

    public void setReimbursementPartsAmount(String reimbursementPartsAmount) {
        this.reimbursementPartsAmount = reimbursementPartsAmount;
    }

    public String getReimbursementLaborAmount() {
        return reimbursementLaborAmount;
    }

    public void setReimbursementLaborAmount(String reimbursementLaborAmount) {
        this.reimbursementLaborAmount = reimbursementLaborAmount;
    }

    public String getRedeemableFlag() {
        return redeemableFlag;
    }

    public void setRedeemableFlag(String redeemableFlag) {
        this.redeemableFlag = redeemableFlag;
    }

    public String getExpiredFlag() {
        return expiredFlag;
    }

    public void setExpiredFlag(String expiredFlag) {
        this.expiredFlag = expiredFlag;
    }

    public String getReimburseByInterval() {
        return reimburseByInterval;
    }

    public void setReimburseByInterval(String reimburseByInterval) {
        this.reimburseByInterval = reimburseByInterval;
    }

    public String getReimbursementByPartsAndLabor() {
        return reimbursementByPartsAndLabor;
    }

    public void setReimbursementByPartsAndLabor(String reimbursementByPartsAndLabor) {
        this.reimbursementByPartsAndLabor = reimbursementByPartsAndLabor;
    }

    public String getDisplayReimbursementAmount() {
        return displayReimbursementAmount;
    }

    public void setDisplayReimbursementAmount(String displayReimbursementAmount) {
        this.displayReimbursementAmount = displayReimbursementAmount;
    }

    public String getReimbursementPaid() {
        return reimbursementPaid;
    }

    public void setReimbursementPaid(String reimbursementPaid) {
        this.reimbursementPaid = reimbursementPaid;
    }

    public String getReimbursementForfeited() {
        return reimbursementForfeited;
    }

    public void setReimbursementForfeited(String reimbursementForfeited) {
        this.reimbursementForfeited = reimbursementForfeited;
    }

    public String getSentReminder() {
        return sentReminder;
    }

    public void setSentReminder(String sentReminder) {
        this.sentReminder = sentReminder;
    }

    public String getCoverageDescription() {
        return coverageDescription;
    }

    public void setCoverageDescription(String coverageDescription) {
        this.coverageDescription = coverageDescription;
    }

    public String getCoverageName() {
        return coverageName;
    }

    public void setCoverageName(String coverageName) {
        this.coverageName = coverageName;
    }

    public String getLaborHours() {
        return laborHours;
    }

    public void setLaborHours(String laborHours) {
        this.laborHours = laborHours;
    }

    public String getLaborRate() {
        return laborRate;
    }

    public void setLaborRate(String laborRate) {
        this.laborRate = laborRate;
    }

    public String getLaborPartsCost() {
        return laborPartsCost;
    }

    public void setLaborPartsCost(String laborPartsCost) {
        this.laborPartsCost = laborPartsCost;
    }

    public String getIsOptional() {
        return isOptional;
    }

    public void setIsOptional(String isOptional) {
        this.isOptional = isOptional;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getTotalServiceCount() {
        return totalServiceCount;
    }

    public void setTotalServiceCount(String totalServiceCount) {
        this.totalServiceCount = totalServiceCount;
    }

    public String getAvailableServiceCount() {
        return availableServiceCount;
    }

    public void setAvailableServiceCount(String availableServiceCount) {
        this.availableServiceCount = availableServiceCount;
    }

    public String getServiceAvailableMessage() {
        return serviceAvailableMessage;
    }

    public void setServiceAvailableMessage(String serviceAvailableMessage) {
        this.serviceAvailableMessage = serviceAvailableMessage;
    }

    public String getProductPlanCoverageId() {
        return productPlanCoverageId;
    }

    public void setProductPlanCoverageId(String productPlanCoverageId) {
        this.productPlanCoverageId = productPlanCoverageId;
    }

    public String getPpmServiceCatalogId() {
        return ppmServiceCatalogId;
    }

    public void setPpmServiceCatalogId(String ppmServiceCatalogId) {
        this.ppmServiceCatalogId = ppmServiceCatalogId;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public String getClaimDealerId() {
        return claimDealerId;
    }

    public void setClaimDealerId(String claimDealerId) {
        this.claimDealerId = claimDealerId;
    }

    public String getClaimDealerName() {
        return claimDealerName;
    }

    public void setClaimDealerName(String claimDealerName) {
        this.claimDealerName = claimDealerName;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getServiceSubcostList() {
        return serviceSubcostList;
    }

    public void setServiceSubcostList(String serviceSubcostList) {
        this.serviceSubcostList = serviceSubcostList;
    }

    public String getProductCodePriority() {
        return productCodePriority;
    }

    public void setProductCodePriority(String productCodePriority) {
        this.productCodePriority = productCodePriority;
    }

    public String getServiceNotes() {
        return serviceNotes;
    }

    public void setServiceNotes(String serviceNotes) {
        this.serviceNotes = serviceNotes;
    }

    public String getProgramCoverageId() {
        return programCoverageId;
    }

    public void setProgramCoverageId(String programCoverageId) {
        this.programCoverageId = programCoverageId;
    }

    public String getIsServiceNoteRequired() {
        return isServiceNoteRequired;
    }

    public void setIsServiceNoteRequired(String isServiceNoteRequired) {
        this.isServiceNoteRequired = isServiceNoteRequired;
    }

    public ServiceDetails getServiceDetails() {
        return serviceDetails;
    }

    public void setServiceDetails(ServiceDetails serviceDetails) {
        this.serviceDetails = serviceDetails;
    }

}
