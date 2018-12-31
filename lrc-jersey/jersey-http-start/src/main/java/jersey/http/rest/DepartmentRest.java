package jersey.http.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.*;


@Path("dept")
public class DepartmentRest {

//    @GET
//    public String hi() {
//        return "hi";
//    }

    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Department> list() {
        List<Department> dept = new ArrayList<Department>();
        dept.add(new Department(1L, "dept1"));
        dept.add(new Department(2L, "dept2"));
        return dept;
    }

    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Department get(@PathParam("id") Long id) {
        return new Department(id, "dept2");
    }

    @POST //2
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Department save(@FormParam("name") String name) {
        System.out.println(name);
        Department d = new Department(3L, name);
        return d;
    }

    @PUT //3
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Department update(@PathParam("id") Long id, @FormParam("name") String name) {
        Department d = new Department(id, name);
        return d;
    }

    @DELETE //4
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public void delete(@PathParam("id") Long id) {
        System.out.println("删除部门：" + id);
    }
}