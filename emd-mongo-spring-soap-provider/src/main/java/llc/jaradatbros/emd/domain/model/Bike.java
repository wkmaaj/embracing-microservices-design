package llc.jaradatbros.emd.domain.model;

import org.springframework.data.annotation.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Bike {
    @Id
    private String id;

    private String name;
    private BikeComponent frontChainwheel;
    private BikeComponent frontDerailleur;
    private BikeComponent rearDerailleur;
    private BikeComponent cassetteSprocket;

}
