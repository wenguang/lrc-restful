package jersey.http.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.*;


@Path("dept")
public class DepartmentRest {

//    @GET
//    public String hi() {
//        return "hi";
//    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Department> list() {
        List<Department> dept = new ArrayList<Department>();
        dept.add(new Department(1L, "dept1"));
        dept.add(new Department(2L, "dept2"));
        return dept;
    }
//
//    @GET
//    @Path("{id}")
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Department get(@PathParam("id") Long id) {
//        return new Department(id, "dept2");
//    }
//
//    @POST //2
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Department save(@FormParam("name") String name) {
//        Department d = new Department(1L, name);
//        return d;
//    }
//
//    @PUT //3
//    @Path("{id}")
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Department update(@PathParam("id") Long id, @FormParam("name") String name) {
//        Department d = new Department(id, name);
//        return d;
//    }
//
//    @DELETE //4
//    @Path("{id}")
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public void delete(@PathParam("id") Long id) {
//        System.out.println("删除部门：" + id);
//    }
}