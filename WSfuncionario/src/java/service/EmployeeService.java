/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import models.entities.Employee;

/**
 * REST Web Service
 *
 * @author Alisson
 */
@Path("employees")
public class EmployeeService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EmployeeService
     */
    public EmployeeService() {
    }

    /**
     * Retrieves representation of an instance of service.EmployeeService
     * @return an instance of models.entities.Employee
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificEmployee(@PathParam("id") int id) {
        Employee e = new Employee();
        e.setId(id);
//        System.out.println(e.getEmployee().getNome());
        
        return Response
                .status(Response.Status.OK)
                .header("Access-Control-Allow-Origin", "*")
                .entity(e.getEmployee())
                .build();
        
    }
    
    /**
     * Retrieves representation of an instance of service.EmployeeService
     * @return an instance of models.entities.Employee
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEmployee() {
        Employee e = new Employee();
        GenericEntity<List<Employee>> list = new GenericEntity<List<Employee>>(e.getAll()) {};
        
        return Response
                .status(Response.Status.OK)
                .header("Access-Control-Allow-Origin", "*")
                .entity(list)
                .build();
        
    }
    
     /**
     * Retrieves representation of an instance of service.EmployeeService
     * @return an instance of models.entities.Employee
     */
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteJson(@PathParam("id") int id) {
        Employee e = new Employee();
        e.setId(id);
        e.delete();
    }
    
    
     /**
     * Retrieves representation of an instance of service.EmployeeService
     * @return an instance of models.entities.Employee
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(Employee e) {
        e.add();
    }

    /**
     * PUT method for updating or creating an instance of EmployeeService
     * @param content representation for the resource
     */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Employee e, @PathParam("id") int id) {
        e.setId(id);
        e.update();
    }
}
