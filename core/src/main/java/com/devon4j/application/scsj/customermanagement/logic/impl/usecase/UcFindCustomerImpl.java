package com.devon4j.application.scsj.customermanagement.logic.impl.usecase;

import java.util.Optional;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devon4j.application.scsj.customermanagement.dataaccess.api.CustomerEntity;
import com.devon4j.application.scsj.customermanagement.logic.api.to.CustomerEto;
import com.devon4j.application.scsj.customermanagement.logic.api.to.CustomerSearchCriteriaTo;
import com.devon4j.application.scsj.customermanagement.logic.api.usecase.UcFindCustomer;
import com.devon4j.application.scsj.customermanagement.logic.base.usecase.AbstractCustomerUc;

/**
 * Use case implementation for searching, filtering and getting Customers
 */
@Named
@Validated
@Transactional
public class UcFindCustomerImpl extends AbstractCustomerUc implements UcFindCustomer {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindCustomerImpl.class);

  @Override
  public CustomerEto findCustomer(long id) {

    LOG.debug("Get Customer with id {} from database.", id);
    Optional<CustomerEntity> foundEntity = getCustomerRepository().findById(id);
    if (foundEntity.isPresent())
      return getBeanMapper().map(foundEntity.get(), CustomerEto.class);
    else
      return null;
  }

  @Override
  public Page<CustomerEto> findCustomers(CustomerSearchCriteriaTo criteria) {

    Page<CustomerEntity> customers = getCustomerRepository().findByCriteria(criteria);
    return mapPaginatedEntityList(customers, CustomerEto.class);
  }

}
