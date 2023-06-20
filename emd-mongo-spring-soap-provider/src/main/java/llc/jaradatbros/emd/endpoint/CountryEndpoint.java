/**
 * Copyright 2023 JaradatBros LLC.
 *
 * Licensed under the MIT License ("the License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://spdx.org/licenses/MIT.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package llc.jaradatbros.emd.endpoint;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import llc.jaradatbros.emd.api.soap.mongo.Country;
import llc.jaradatbros.emd.api.soap.mongo.Currency;
import llc.jaradatbros.emd.api.soap.mongo.GetCountryRequest;
import llc.jaradatbros.emd.api.soap.mongo.GetCountryResponse;
import llc.jaradatbros.emd.constants.WebServiceConstants;
import llc.jaradatbros.emd.domain.repository.BaseMongoRepository;

@Endpoint("CountriesSoapEndpoint")
public class CountryEndpoint {
    private Logger logger = LoggerFactory.getLogger(CountryEndpoint.class);
    private BaseMongoRepository<llc.jaradatbros.emd.domain.model.Country> countriesRepository;

    public CountryEndpoint(BaseMongoRepository<llc.jaradatbros.emd.domain.model.Country> countriesRepository) {
        this.countriesRepository = countriesRepository;
        logger.info("Bean instantiated");
    }

    @PayloadRoot(namespace = WebServiceConstants.ENTITIES_WS_SOAP_NAMESPACE_URI, localPart = "GetCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        logger.info("Looking up country name: {}", request.getName());

        GetCountryResponse response = new GetCountryResponse();
        try {
            List<llc.jaradatbros.emd.domain.model.Country> dbResponseList = countriesRepository.findByName(request.getName());
            logger.info("Received response from database: {}", dbResponseList);
            llc.jaradatbros.emd.domain.model.Country dbResponse = dbResponseList.get(0);
            logger.info("Extracted zero-th entry: {}", dbResponse);

            Country country = new Country();
            country.setCapital(dbResponse.getCapital());
            country.setCurrency(Currency.valueOf(dbResponse.getCurrency()));
            country.setName(dbResponse.getName());
            // country.setPopulation(BigInteger.valueOf(dbResponse.getPopulation()));

            response.setCountry(country);
        } catch(Exception e) {
            logger.error("Application encountered an exception", e);
        }

        return response;
    }

}