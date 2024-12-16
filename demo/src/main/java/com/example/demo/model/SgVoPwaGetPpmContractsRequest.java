package com.example.demo.model;

import jakarta.xml.bind.annotation.XmlElement;

public class SgVoPwaGetPpmContractsRequest {

    @XmlElement(name = "search_type", required = true)
    protected String searchType;

    @XmlElement(name = "search_value", required = true)
    protected String searchValue;

    @XmlElement(name = "image_type", required = true)
    protected String imageType;

    @XmlElement(name = "user_id", required = true)
    protected String userId;

    @XmlElement(required = true)
    protected String odometer;

    @XmlElement(required = true)
    protected String trim;

    @XmlElement(required = true)
    protected String make;

    @XmlElement(required = true)
    protected String model;

    @XmlElement(required = true)
    protected String year;

    @XmlElement(required = true)
    protected String dealer;

    // Getters and setters...
    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOdometer() {
        return odometer;
    }

    public void setOdometer(String odometer) {
        this.odometer = odometer;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
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

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

}
