package llc.jaradatbros.emd.domain.model;

import java.math.BigInteger;
import java.util.Map;

import org.springframework.data.annotation.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class BikeComponent {
    @Id
    private String id;

    private String name;
    private String manufacturer;
    private String model;
    private BigInteger numberOfCogs;
    private BigInteger numberOfSpeeds;
    private Map<Integer, Integer> numberOfTeethPerChainring;

}
