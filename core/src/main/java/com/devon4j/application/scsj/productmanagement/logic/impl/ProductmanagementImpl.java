package com.devon4j.application.scsj.productmanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devon4j.application.scsj.general.logic.base.AbstractComponentFacade;
import com.devon4j.application.scsj.productmanagement.logic.api.Productmanagement;
import com.devon4j.application.scsj.productmanagement.logic.api.to.ProductEto;
import com.devon4j.application.scsj.productmanagement.logic.api.to.ProductSearchCriteriaTo;
import com.devon4j.application.scsj.productmanagement.logic.api.usecase.UcFindProduct;
import com.devon4j.application.scsj.productmanagement.logic.api.usecase.UcManageProduct;

/**
 * Implementation of component interface of productmanagement
 */
@Named
public class ProductmanagementImpl extends AbstractComponentFacade implements Productmanagement {

  @Inject
  private UcFindProduct ucFindProduct;

  @Inject
  private UcManageProduct ucManageProduct;

  @Override
  public ProductEto findProduct(long id) {

    return this.ucFindProduct.findProduct(id);
  }

  @Override
  public Page<ProductEto> findProducts(ProductSearchCriteriaTo criteria) {

    return this.ucFindProduct.findProducts(criteria);
  }

  @Override
  public ProductEto saveProduct(ProductEto product) {

    return this.ucManageProduct.saveProduct(product);
  }

  @Override
  public boolean deleteProduct(long id) {

    return this.ucManageProduct.deleteProduct(id);
  }
}
