package at.fhcampus.se.wsdlclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CalculatorConfiguration {
    @Bean
    public Jaxb2Marshaller marshallerCalculator() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("at.fhcampus.se.wsdlclient.calculator");
        return marshaller;
    }

    @Bean
    public CalculatorClient calculatorClient(Jaxb2Marshaller marshallerCalculator) {
        CalculatorClient client = new CalculatorClient();
        client.setDefaultUri("http://localhost:8000/ws");
        client.setMarshaller(marshallerCalculator);
        client.setUnmarshaller(marshallerCalculator);
        return client;
    }
}
