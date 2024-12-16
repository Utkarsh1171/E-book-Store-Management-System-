package com.filter.male_or_female.dto;

public class GenderCountResponse {

    private long maleCount;
    private long femaleCount;

    // Constructor
    public GenderCountResponse(long maleCount, long femaleCount) {
        this.maleCount = maleCount;
        this.femaleCount = femaleCount;
    }

    // Getters and Setters
    public long getMaleCount() {
        return maleCount;
    }

    public void setMaleCount(long maleCount) {
        this.maleCount = maleCount;
    }

    public long getFemaleCount() {
        return femaleCount;
    }

    public void setFemaleCount(long femaleCount) {
        this.femaleCount = femaleCount;
    }
}
