package com.devon4j.application.scsj.productmanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devon4j.application.scsj.productmanagement.logic.api.Productmanagement;
import com.devon4j.application.scsj.productmanagement.logic.api.to.ProductEto;
import com.devon4j.application.scsj.productmanagement.logic.api.to.ProductSearchCriteriaTo;
import com.devon4j.application.scsj.productmanagement.service.api.rest.ProductmanagementRestService;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Productmanagement}.
 */
@Named("ProductmanagementRestService")
public class ProductmanagementRestServiceImpl implements ProductmanagementRestService {

  @Inject
  private Productmanagement productmanagement;

  @Override
  public ProductEto getProduct(long id) {

    return this.productmanagement.findProduct(id);
  }

  @Override
  public ProductEto saveProduct(ProductEto product) {

    return this.productmanagement.saveProduct(product);
  }

  @Override
  public void deleteProduct(long id) {

    this.productmanagement.deleteProduct(id);
  }

  @Override
  public Page<ProductEto> findProducts(ProductSearchCriteriaTo searchCriteriaTo) {

    return this.productmanagement.findProducts(searchCriteriaTo);
  }
}