package com.example.demo.model;

import jakarta.xml.bind.annotation.XmlElement;

public class Contract {

    @XmlElement(name = "contractNumber")
    private String contractNumber;

    @XmlElement(name = "customerName")
    private String customerName;

    @XmlElement(name = "dealerId")
    private String dealerId;

    @XmlElement(name = "dealerName")
    private String dealerName;

    @XmlElement(name = "displayIcon")
    private String displayIcon;

    @XmlElement(name = "ppmClaimCatalogId")
    private String ppmClaimCatalogId;

    @XmlElement(name = "productName")
    private String productName;

    @XmlElement(name = "planName")
    private String planName;

    @XmlElement(name = "make")
    private String make;

    @XmlElement(name = "model")
    private String model;

    @XmlElement(name = "year")
    private String year;

    @XmlElement(name = "vin")
    private String vin;

    @XmlElement(name = "webConId")
    private String webConId;

    @XmlElement(name = "serviceCount")
    private String serviceCount;

    @XmlElement(name = "uploadDocument")
    private String uploadDocument;

    @XmlElement(name = "coverageCode")
    private String coverageCode;

    @XmlElement(name = "displayDisclaimer")
    private String displayDisclaimer;

    @XmlElement(name = "productCode")
    private String productCode;

    @XmlElement(name = "availableServices")
    private AvailableServices availableServices;

    @XmlElement(name = "openClaims")
    private OpenClaim openClaims;

    @XmlElement(name = "serviceIcons")
    private ServiceIcon serviceIcons;

    // Getters and setters...
    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getDisplayIcon() {
        return displayIcon;
    }

    public void setDisplayIcon(String displayIcon) {
        this.displayIcon = displayIcon;
    }

    public String getPpmClaimCatalogId() {
        return ppmClaimCatalogId;
    }

    public void setPpmClaimCatalogId(String ppmClaimCatalogId) {
        this.ppmClaimCatalogId = ppmClaimCatalogId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getWebConId() {
        return webConId;
    }

    public void setWebConId(String webConId) {
        this.webConId = webConId;
    }

    public String getServiceCount() {
        return serviceCount;
    }

    public void setServiceCount(String serviceCount) {
        this.serviceCount = serviceCount;
    }

    public String getUploadDocument() {
        return uploadDocument;
    }

    public void setUploadDocument(String uploadDocument) {
        this.uploadDocument = uploadDocument;
    }

    public String getCoverageCode() {
        return coverageCode;
    }

    public void setCoverageCode(String coverageCode) {
        this.coverageCode = coverageCode;
    }

    public String getDisplayDisclaimer() {
        return displayDisclaimer;
    }

    public void setDisplayDisclaimer(String displayDisclaimer) {
        this.displayDisclaimer = displayDisclaimer;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public AvailableServices getAvailableServices() {
        return availableServices;
    }

    public void setAvailableServices(AvailableServices availableServices) {
        this.availableServices = availableServices;
    }

    public OpenClaim getOpenClaims() {
        return openClaims;
    }

    public void setOpenClaims(OpenClaim openClaims) {
        this.openClaims = openClaims;
    }

    public ServiceIcon getServiceIcons() {
        return serviceIcons;
    }

    public void setServiceIcons(ServiceIcon serviceIcons) {
        this.serviceIcons = serviceIcons;
    }

}
