package at.fhcampus.se.wsdlclient.soapclients;

import at.fhcampus.se.wsdlclient.exchange.CurrencyRequest;
import at.fhcampus.se.wsdlclient.exchange.ExchangeCurrencyRequest;
import at.fhcampus.se.wsdlclient.exchange.ExchangeCurrencyResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CurrencyClient extends WebServiceGatewaySupport {

    public ExchangeCurrencyResponse getExchangeRate(String fromCurrency, float fromCurrencyAmount, String toCurrency) {
        ExchangeCurrencyRequest exchangeCurrencyRequest = new ExchangeCurrencyRequest();

        CurrencyRequest currencyRequest = new CurrencyRequest();
        currencyRequest.setFromCurrency(fromCurrency);
        currencyRequest.setFromCurrencyAmount(fromCurrencyAmount);
        currencyRequest.setToCurrency(toCurrency);

        exchangeCurrencyRequest.setRequest(currencyRequest);
        ExchangeCurrencyResponse response = (ExchangeCurrencyResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        "http://localhost:8080/ws/exchangeCurrencyRequest", // http://localhost:8000/ws/
                        exchangeCurrencyRequest,
                        new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/ExchangeCurrencyRequest")
                );

        return response;
    }

}
