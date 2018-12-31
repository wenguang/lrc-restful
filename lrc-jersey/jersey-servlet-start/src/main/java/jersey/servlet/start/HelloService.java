package jersey.servlet.start;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class HelloService {

    @GET
    @Path("hi")
    @Produces(MediaType.TEXT_PLAIN)
    public String hi() {
        return "hi, jersey!";
    }


    @POST
    @Path("echo")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String echo(@FormParam("msg") String msg) {
        return "client say: " + msg;
    }

    @POST //2
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String save(@FormParam("name") String name) {
        return  name;
    }
}
