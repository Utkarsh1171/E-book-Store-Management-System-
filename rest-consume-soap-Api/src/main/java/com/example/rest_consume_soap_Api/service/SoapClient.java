//package com.example.rest_consume_soap_Api.service;
//
//import com.example.rest_consume_soap_Api.numbertoword.NumberToWords;
//import com.example.rest_consume_soap_Api.numbertoword.NumberToWordsResponse;
//import java.math.BigInteger;
//import org.springframework.stereotype.Service;
//import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
//
//@Service("NumberConversion")
//public class SoapClient extends WebServiceGatewaySupport {
//
//    private static final String ENDPOINT = "https://www.dataaccess.com/webservicesserver/NumberConversion.wso?wsdl";
//
//    public String convertirNumeroPalabras(Long numero) {
//        // Ensure that 'numero' is not null
//        if (numero == null) {
//            throw new IllegalArgumentException("The number must not be null.");
//        }
//
//        NumberToWords request = new NumberToWords();
//        request.setUbiNum(BigInteger.valueOf(numero));
//
//        // Send request and receive response
//        NumberToWordsResponse response = (NumberToWordsResponse) getWebServiceTemplate().marshalSendAndReceive(
//                ENDPOINT, request
//        );
//
//        // Return the response as a String
//        return response.getNumberToWordsResult();
//    }
//}
