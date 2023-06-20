package llc.jaradatbros.emd.domain.model;

import org.springframework.data.annotation.Id;

import llc.jaradatbros.emd.api.soap.mongo.Currency;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Country {
    @Id
    private String id;

    private String name;
    private Integer population;
    private String capital;
    private Currency currency;
}
