package at.fhcampus.se.wsdlclient.soapclients;

import at.fhcampus.se.wsdlclient.calculator.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CalculatorClient extends WebServiceGatewaySupport {

    public AddResponse add(int input1, int input2) {
        AddType type = new AddType();
        type.setFirstNum(input1);
        type.setSecondNum(input2);

        AddRequest addRequest = new AddRequest();
        addRequest.setInputRecord(type);

        AddResponse response = (AddResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        "http://localhost:8080/ws/addRequest", // http://localhost:8000/ws/
                        addRequest
                );

        return response;
    }

    public SubtractResponse subtract(int input1, int input2) {
        SubtractType type = new SubtractType();
        type.setFirstNum(input1);
        type.setSecondNum(input2);

        SubtractRequest subtractRequest = new SubtractRequest();
        subtractRequest.setInputRecord(type);

        SubtractResponse response = (SubtractResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        "http://localhost:8080/ws/subtractRequest", // http://localhost:8000/ws/
                        subtractRequest
                );

        return response;
    }

}
