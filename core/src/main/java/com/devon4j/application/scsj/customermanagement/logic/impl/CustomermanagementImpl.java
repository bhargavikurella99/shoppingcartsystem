package com.devon4j.application.scsj.customermanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devon4j.application.scsj.customermanagement.logic.api.Customermanagement;
import com.devon4j.application.scsj.customermanagement.logic.api.to.CustomerEto;
import com.devon4j.application.scsj.customermanagement.logic.api.to.CustomerSearchCriteriaTo;
import com.devon4j.application.scsj.customermanagement.logic.api.usecase.UcFindCustomer;
import com.devon4j.application.scsj.customermanagement.logic.api.usecase.UcManageCustomer;
import com.devon4j.application.scsj.general.logic.base.AbstractComponentFacade;

/**
 * Implementation of component interface of customermanagement
 */
@Named
public class CustomermanagementImpl extends AbstractComponentFacade implements Customermanagement {

  @Inject
  private UcFindCustomer ucFindCustomer;

  @Inject
  private UcManageCustomer ucManageCustomer;

  @Override
  public CustomerEto findCustomer(long id) {

    return this.ucFindCustomer.findCustomer(id);
  }

  @Override
  public Page<CustomerEto> findCustomers(CustomerSearchCriteriaTo criteria) {

    return this.ucFindCustomer.findCustomers(criteria);
  }

  @Override
  public CustomerEto saveCustomer(CustomerEto customer) {

    return this.ucManageCustomer.saveCustomer(customer);
  }

  @Override
  public boolean deleteCustomer(long id) {

    return this.ucManageCustomer.deleteCustomer(id);
  }
}
