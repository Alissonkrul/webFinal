/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

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
import javax.ws.rs.core.MediaType;
import models.entities.Employee;

/**
 * REST Web Service
 *
 * @author Alisson
 */
@Path("employee")
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
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getJson(String id) {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
     /**
     * Retrieves representation of an instance of service.EmployeeService
     * @return an instance of models.entities.Employee
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
     /**
     * Retrieves representation of an instance of service.EmployeeService
     * @return an instance of models.entities.Employee
     */
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    
     /**
     * Retrieves representation of an instance of service.EmployeeService
     * @return an instance of models.entities.Employee
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of EmployeeService
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Employee content) {
    }
}
