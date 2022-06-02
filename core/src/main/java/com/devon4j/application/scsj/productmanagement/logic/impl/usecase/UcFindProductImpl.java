package com.devon4j.application.scsj.productmanagement.logic.impl.usecase;

import java.util.Optional;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devon4j.application.scsj.productmanagement.dataaccess.api.ProductEntity;
import com.devon4j.application.scsj.productmanagement.logic.api.to.ProductEto;
import com.devon4j.application.scsj.productmanagement.logic.api.to.ProductSearchCriteriaTo;
import com.devon4j.application.scsj.productmanagement.logic.api.usecase.UcFindProduct;
import com.devon4j.application.scsj.productmanagement.logic.base.usecase.AbstractProductUc;

/**
 * Use case implementation for searching, filtering and getting Products
 */
@Named
@Validated
@Transactional
public class UcFindProductImpl extends AbstractProductUc implements UcFindProduct {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindProductImpl.class);

  @Override
  public ProductEto findProduct(long id) {

    LOG.debug("Get Product with id {} from database.", id);
    Optional<ProductEntity> foundEntity = getProductRepository().findById(id);
    if (foundEntity.isPresent())
      return getBeanMapper().map(foundEntity.get(), ProductEto.class);
    else
      return null;
  }

  @Override
  public Page<ProductEto> findProducts(ProductSearchCriteriaTo criteria) {

    Page<ProductEntity> products = getProductRepository().findByCriteria(criteria);
    return mapPaginatedEntityList(products, ProductEto.class);
  }

}
