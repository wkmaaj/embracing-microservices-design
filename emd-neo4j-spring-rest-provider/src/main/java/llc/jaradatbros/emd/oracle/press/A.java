package llc.jaradatbros.emd.oracle.press;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.HttpStatusCodeException;

class A extends HttpStatusCodeException {
    A(HttpStatusCode status) {
        super(status);
        System.out.println(this.getClass().getName() + " | Instantiating constructor... " + status);
    }
}
