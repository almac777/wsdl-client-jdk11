package at.fhcampus.se.wsdlclient.soapconfigs;

import at.fhcampus.se.wsdlclient.soapclients.CurrencyClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CurrencyConfiguration {
    @Bean
    public Jaxb2Marshaller marshallerCurrency() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("at.fhcampus.se.wsdlclient.exchange");
        return marshaller;
    }

    @Bean
    public CurrencyClient currencyClient(Jaxb2Marshaller marshallerCurrency) {
        CurrencyClient client = new CurrencyClient();
        client.setDefaultUri("http://localhost:8000/ws");
        client.setMarshaller(marshallerCurrency);
        client.setUnmarshaller(marshallerCurrency);
        return client;
    }
}
