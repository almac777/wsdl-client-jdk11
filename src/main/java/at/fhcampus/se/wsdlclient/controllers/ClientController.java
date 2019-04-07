package at.fhcampus.se.wsdlclient.controllers;

import at.fhcampus.se.wsdlclient.calculator.AddResponse;
import at.fhcampus.se.wsdlclient.calculator.SubtractResponse;
import at.fhcampus.se.wsdlclient.soapclients.CalculatorClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private CalculatorClient calculatorClient;

    @RequestMapping(value = "/add/{operand1}/{operand2}", method = RequestMethod.GET)
    public int add(@PathVariable("operand1") int operand1, @PathVariable("operand2") int operand2) {
        AddResponse response = calculatorClient.add(operand1, operand2);
        System.out.println(">> " + response.getOut());
        return response.getOut();
    }

    @RequestMapping(value = "/subtract/{operand1}/{operand2}", method = RequestMethod.GET)
    public int subtract(@PathVariable("operand1") int operand1, @PathVariable("operand2") int operand2) {
        SubtractResponse response = calculatorClient.subtract(operand1, operand2);
        System.out.println(">> " + response.getOut());
        return response.getOut();
    }

}
