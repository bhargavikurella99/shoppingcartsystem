package com.devon4j.application.scsj.customermanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

import com.devon4j.application.scsj.customermanagement.logic.api.Customermanagement;
import com.devon4j.application.scsj.customermanagement.logic.api.to.CustomerEto;
import com.devon4j.application.scsj.customermanagement.logic.api.to.CustomerSearchCriteriaTo;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Customermanagement}.
 */
@Path("/customermanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface CustomermanagementRestService {

  /**
   * Delegates to {@link Customermanagement#findCustomer}.
   *
   * @param id the ID of the {@link CustomerEto}
   * @return the {@link CustomerEto}
   */
  @GET
  @Path("/customer/{id}/")
  public CustomerEto getCustomer(@PathParam("id") long id);

  /**
   * Delegates to {@link Customermanagement#saveCustomer}.
   *
   * @param customer the {@link CustomerEto} to be saved
   * @return the recently created {@link CustomerEto}
   */
  @POST
  @Path("/customer/")
  public CustomerEto saveCustomer(CustomerEto customer);

  /**
   * Delegates to {@link Customermanagement#deleteCustomer}.
   *
   * @param id ID of the {@link CustomerEto} to be deleted
   */
  @DELETE
  @Path("/customer/{id}/")
  public void deleteCustomer(@PathParam("id") long id);

  /**
   * Delegates to {@link Customermanagement#findCustomerEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding customers.
   * @return the {@link Page list} of matching {@link CustomerEto}s.
   */
  @Path("/customer/search")
  @POST
  public Page<CustomerEto> findCustomers(CustomerSearchCriteriaTo searchCriteriaTo);

}