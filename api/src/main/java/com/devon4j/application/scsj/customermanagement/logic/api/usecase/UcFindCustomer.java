package com.devon4j.application.scsj.customermanagement.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.devon4j.application.scsj.customermanagement.logic.api.to.CustomerEto;
import com.devon4j.application.scsj.customermanagement.logic.api.to.CustomerSearchCriteriaTo;

public interface UcFindCustomer {

  /**
   * Returns a Customer by its id 'id'.
   *
   * @param id The id 'id' of the Customer.
   * @return The {@link CustomerEto} with id 'id'
   */
  CustomerEto findCustomer(long id);

  /**
   * Returns a paginated list of Customers matching the search criteria.
   *
   * @param criteria the {@link CustomerSearchCriteriaTo}.
   * @return the {@link List} of matching {@link CustomerEto}s.
   */
  Page<CustomerEto> findCustomers(CustomerSearchCriteriaTo criteria);

}
