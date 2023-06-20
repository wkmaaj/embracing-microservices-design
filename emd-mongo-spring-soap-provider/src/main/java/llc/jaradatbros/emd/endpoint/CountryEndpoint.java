package llc.jaradatbros.emd.endpoint;

import java.math.BigInteger;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import llc.jaradatbros.emd.api.soap.mongo.GetCountryRequest;
import llc.jaradatbros.emd.api.soap.mongo.GetCountryResponse;
import llc.jaradatbros.emd.constants.WebServiceConstants;
import llc.jaradatbros.emd.domain.model.Country;
import llc.jaradatbros.emd.domain.repository.BaseMongoRepository;

@Endpoint("CountriesSoapEndpoint")
public class CountryEndpoint {
    private BaseMongoRepository<Country> countriesRepository;

    public CountryEndpoint(BaseMongoRepository<Country> countriesRepository) {
        this.countriesRepository = countriesRepository;
    }

    @PayloadRoot(namespace = WebServiceConstants.COUNTRIES_WS_SOAP_NAMESPACE_URI, localPart = "GetCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        Country repoResponse = countriesRepository.findByName(request.getName()).get(0);
        llc.jaradatbros.emd.api.soap.mongo.Country country = new llc.jaradatbros.emd.api.soap.mongo.Country();
        country.setCapital(repoResponse.getCapital());
        country.setCurrency(repoResponse.getCurrency());
        country.setName(repoResponse.getName());
        country.setPopulation(BigInteger.valueOf(repoResponse.getPopulation()));
        response.setCountry(country);
        return response;
    }

}