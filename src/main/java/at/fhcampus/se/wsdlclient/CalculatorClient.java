package at.fhcampus.se.wsdlclient;

import at.fhcampus.se.wsdlclient.calculator.AddRequest;
import at.fhcampus.se.wsdlclient.calculator.AddResponse;
import at.fhcampus.se.wsdlclient.calculator.AddType;
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
                        addRequest,
                        new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/AddRequest")
                );

        return response;
    }

}
