package llc.jaradatbros.emd.domain.model;

import java.util.Date;

import lombok.Data;
import lombok.NonNull;

@Data
public class User {

    @NonNull
    private String firstName;

    private String middleName;

    @NonNull
    private String lastName;

    @NonNull
    private Date dateOfBirth;

}
