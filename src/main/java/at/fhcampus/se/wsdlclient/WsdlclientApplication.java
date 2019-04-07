package at.fhcampus.se.wsdlclient;

import at.fhcampus.se.wsdlclient.calculator.AddResponse;
import at.fhcampus.se.wsdlclient.soapclients.CalculatorClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WsdlclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(WsdlclientApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(CalculatorClient calculatorClient) {
        return args -> {
            AddResponse response = calculatorClient.add(10, 20);
            System.out.println(">> " + response.getOut());
        };
    }

}
