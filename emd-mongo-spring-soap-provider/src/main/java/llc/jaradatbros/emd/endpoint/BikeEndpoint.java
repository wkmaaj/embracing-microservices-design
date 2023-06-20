package llc.jaradatbros.emd.endpoint;

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
    private BaseMongoRepository<llc.jaradatbros.emd.domain.model.Bike> bikeRepository;

    public BikeEndpoint(BaseMongoRepository<llc.jaradatbros.emd.domain.model.Bike> bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @PayloadRoot(namespace = WebServiceConstants.BIKES_WS_SOAP_NAMESPACE_URI, localPart = "GetBikeRequest")
    @ResponsePayload
    public GetBikeResponse getBike(@RequestPayload GetBikeRequest request) {
        Bike bike = new Bike();
        BikeComponent cassetteSprocket = new BikeComponent();
        BikeComponent frontChainwheel = new BikeComponent();
        BikeComponent frontDerailleur = new BikeComponent();
        BikeComponent rearDerailleur = new BikeComponent();

        bike.setCassetteSprocket(cassetteSprocket);
        bike.setFrontChainwheel(frontChainwheel);
        bike.setFrontDerailleur(frontDerailleur);
        bike.setRearDerailleur(rearDerailleur);

        llc.jaradatbros.emd.domain.model.Bike dbBike = bikeRepository.findByName(request.getName()).get(0);
        bike.setName(dbBike.getName());
        bike.getFrontChainwheel().setManufacturer(dbBike.getFrontChainwheel().getManufacturer());
        bike.getFrontChainwheel().setModel(dbBike.getFrontChainwheel().getModel());
        bike.getFrontChainwheel().setName(dbBike.getFrontChainwheel().getName());

        GetBikeResponse response = new GetBikeResponse();
        response.setBike(bike);
        return response;
    }

}
