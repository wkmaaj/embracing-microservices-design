package llc.jaradatbros.emd.domain.model;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@ToString(includeFieldNames = true)
@Data
public class Greeting {

    @NonNull
    private String msg;

    @NonNull
    private String name;

}
