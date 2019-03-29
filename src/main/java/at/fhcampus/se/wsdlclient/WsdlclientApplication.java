package at.fhcampus.se.wsdlclient;

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
    CommandLineRunner lookup(CurrencyClient currencyClient) {
        return args -> {
            String country = "Spain";

            if (args.length > 0) {
                country = args[0];
            }
            ExchangeCurrencyResponse response = currencyClient.getExchangeRate("USD", 100, "EUR");
            System.out.println(response.getResponse().toCurrency + " " + response.getResponse().toCurrencyAmount);
        };
    }

}
