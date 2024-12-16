package com.example.rest_consume_soap_Api.service;

import com.example.rest_consume_soap_Api.numbertoword.NumberToWords;
import com.example.rest_consume_soap_Api.numbertoword.NumberToWordsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.math.BigInteger;

@Service
public class NumberConversionService {

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    public String convertNumber(String number) {
        // Convert the input number to BigInteger
        BigInteger bigIntegerNumber = BigInteger.valueOf(Long.parseLong(number));

        // Create the request object
        NumberToWords request = new NumberToWords();
        request.setUbiNum(bigIntegerNumber);  // Set BigInteger number

        // Send the request and get the response
        Object response = webServiceTemplate.marshalSendAndReceive(
                "https://www.dataaccess.com/webservicesserver/NumberConversion.wso",
                request
        );

        // Cast the response to the appropriate response class and return the result
        return ((NumberToWordsResponse) response).getNumberToWordsResult();
    }
}
