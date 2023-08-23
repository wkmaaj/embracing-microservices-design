package llc.jaradatbros.emd.oracle.press;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class BTest {

    @Test
    void testInitMethod() {
        B obj = new B(HttpStatus.ACCEPTED);
        System.out.println(obj.toString());
    }

}
