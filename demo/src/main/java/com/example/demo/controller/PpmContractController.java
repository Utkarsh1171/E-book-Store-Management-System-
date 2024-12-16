package com.example.demo.controller;

import com.example.demo.model.AvailableServices;
import com.example.demo.model.Contract;
import com.example.demo.model.GetPpmContractsResponse;
import com.example.demo.model.ServiceDetail;
import com.example.demo.model.ServiceDetails;
import com.example.demo.model.ServiceItem;
import com.example.demo.model.SgVoPwaGetPpmContractsRequest;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ppmContracts")
public class PpmContractController {

    @PostMapping("/get")
    public GetPpmContractsResponse getPpmContracts(@RequestBody SgVoPwaGetPpmContractsRequest request) {
        GetPpmContractsResponse response = new GetPpmContractsResponse();

        Contract contract = new Contract();
        // Populate contract fields based on the request
        contract.setContractNumber("12345");
        contract.setCustomerName("John Doe");
        contract.setDealerId("D123");
        contract.setDealerName("Best Dealer");
        contract.setDisplayIcon("http://example.com/icon.png");
        contract.setPpmClaimCatalogId("PPM123");
        contract.setProductName("Extended Warranty");
        contract.setPlanName("Premium Plan");
        contract.setMake(request.getMake());
        contract.setModel(request.getModel());
        contract.setYear(request.getYear());
        contract.setVin("1HGCM82633A123456");
        contract.setWebConId("WEB123");
        contract.setServiceCount("5");
        contract.setUploadDocument("http://example.com/documents/contract123.pdf");
        contract.setCoverageCode("COV123");
        contract.setDisplayDisclaimer("Terms and conditions apply.");
        contract.setProductCode("PROD123");

        // Create available services
        AvailableServices availableServices = new AvailableServices();
        ServiceItem serviceItem = new ServiceItem();
        serviceItem.setPpmIntervalId("INT123");
        serviceItem.setServiceOrderNumber("SO123");
        serviceItem.setRepairOrderNumber("RO123");
        serviceItem.setServiceOdometer("15000");
        serviceItem.setStartOdometer("10000");
        // Set other fields...

        // Adding service details
        ServiceDetails serviceDetails = new ServiceDetails();
        ServiceDetail serviceDetail = new ServiceDetail();
        serviceDetail.setServiceName("Oil Change");
        serviceDetail.setServiceDescription("Full synthetic oil change.");
        serviceDetail.setServiceRate("29.99");
        serviceDetail.setServiceRatePartAmount("20.00");
        serviceDetail.setServiceRateLaborAmount("9.99");
        serviceDetail.setServiceIconId("ICON123");

        serviceDetails.setItem(List.of(serviceDetail));
        serviceItem.setServiceDetails(serviceDetails);

        availableServices.setItem(List.of(serviceItem));
        contract.setAvailableServices(availableServices);

        // Add similar logic for open claims and service icons...
        response.setContract(contract);
        return response;
    }
}
