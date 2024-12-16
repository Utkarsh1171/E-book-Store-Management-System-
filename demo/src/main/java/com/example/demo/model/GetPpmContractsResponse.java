package com.example.demo.model;

import jakarta.xml.bind.annotation.XmlElement;

public class GetPpmContractsResponse {

    @XmlElement(name = "contract")
    private Contract contract;

    // Getters and setters...
    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

}
