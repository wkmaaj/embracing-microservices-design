package llc.jaradatbros.emd.oracle.press;

import org.springframework.http.HttpStatus;

public class B extends A {
    B(HttpStatus status) {
        super(status);
        System.out.println(this.getClass().getName() + " | Instantiating constructor... " + status);
    }
}
