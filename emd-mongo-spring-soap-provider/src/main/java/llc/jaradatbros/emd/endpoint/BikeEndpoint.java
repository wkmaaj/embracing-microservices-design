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

import llc.jaradatbros.emd.api.soap.mongo.Bike;
import llc.jaradatbros.emd.api.soap.mongo.BikeComponent;
import llc.jaradatbros.emd.api.soap.mongo.GetBikeRequest;
import llc.jaradatbros.emd.api.soap.mongo.GetBikeResponse;
import llc.jaradatbros.emd.constants.WebServiceConstants;
import llc.jaradatbros.emd.domain.repository.BaseMongoRepository;

@Endpoint("BikesSoapEndpoint")
public class BikeEndpoint {
    private Logger logger = LoggerFactory.getLogger(BikeEndpoint.class);
    private BaseMongoRepository<llc.jaradatbros.emd.domain.model.Bike> bikeRepository;

    public BikeEndpoint(BaseMongoRepository<llc.jaradatbros.emd.domain.model.Bike> bikeRepository) {
        this.bikeRepository = bikeRepository;
        logger.info("Bean instantiated");
    }

    @PayloadRoot(namespace = WebServiceConstants.ENTITIES_WS_SOAP_NAMESPACE_URI, localPart = "getBikeRequest")
    @ResponsePayload
    public GetBikeResponse getBike(@RequestPayload GetBikeRequest request) {
        logger.info("Looking up bike name: {}", request.getName());

        GetBikeResponse response = new GetBikeResponse();
        try {
            List<llc.jaradatbros.emd.domain.model.Bike> dbResponseList = bikeRepository.findByName(request.getName());
            logger.info("Received response from database: {}", dbResponseList);
            llc.jaradatbros.emd.domain.model.Bike dbResponse = dbResponseList.get(0);
            logger.info("Extracted zero-th entry: {}", dbResponse);

            Bike bike = new Bike();
            bike.setName(dbResponse.getName());

            BikeComponent cassetteSprocket = new BikeComponent();
            bike.setCassetteSprocket(cassetteSprocket);

            BikeComponent frontChainwheel = new BikeComponent();
            bike.setFrontChainwheel(frontChainwheel);
            bike.getFrontChainwheel().setManufacturer(dbResponse.getFrontChainwheel().getManufacturer());
            bike.getFrontChainwheel().setModel(dbResponse.getFrontChainwheel().getModel());
            bike.getFrontChainwheel().setName(dbResponse.getFrontChainwheel().getName());

            BikeComponent frontDerailleur = new BikeComponent();
            bike.setFrontDerailleur(frontDerailleur);

            BikeComponent rearDerailleur = new BikeComponent();
            bike.setRearDerailleur(rearDerailleur);

            response.setBike(bike);
        } catch(Exception e) {
            logger.error("Application encountered an exception", e);
        }

        return response;
    }

}
