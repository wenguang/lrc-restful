package jersey.spring;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("jersey")
public class JerseyService {

    @Path("hello")
    @GET
    public String hello() {
        return "hello jersey";
    }
}
