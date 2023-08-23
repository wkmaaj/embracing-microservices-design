package llc.jaradatbros.emd.domain.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

class Customer {

    @Email private String email;

    @NotBlank private String name;

}
