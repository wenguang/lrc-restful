package jersey.start.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class HelloService {

    @GET
    @Path("hi")
    @Produces(MediaType.TEXT_PLAIN)
    public String hi() {
        return "hi, jersey!";
    }

    @GET
    @Path("msg")
    @Produces(MediaType.TEXT_PLAIN)
    public String msg() {
        return "i am msg";
    }
}
