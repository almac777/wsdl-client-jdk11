package at.fhcampus.se.wsdlclient;

import at.fhcampus.se.wsdlclient.calculator.AddResponse;
import at.fhcampus.se.wsdlclient.calculator.SubtractResponse;
import at.fhcampus.se.wsdlclient.soapclients.CalculatorClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WsdlClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(WsdlClientApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(CalculatorClient calculatorClient) {
        return args -> {
            AddResponse response1 = calculatorClient.add(10, 20);
            SubtractResponse response2 = calculatorClient.subtract(10, 20);
            System.out.println(">> 10 + 20 " + response1.getOut());
            System.out.println(">> 10 - 20 " + response2.getOut());
        };
    }

}
