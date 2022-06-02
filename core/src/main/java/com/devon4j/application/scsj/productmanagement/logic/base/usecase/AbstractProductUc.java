package com.devon4j.application.scsj.productmanagement.logic.base.usecase;

import javax.inject.Inject;

import com.devon4j.application.scsj.general.logic.base.AbstractUc;
import com.devon4j.application.scsj.productmanagement.dataaccess.api.repo.ProductRepository;

/**
 * Abstract use case for Products, which provides access to the commonly necessary data access objects.
 */
public abstract class AbstractProductUc extends AbstractUc {

  /** @see #getProductRepository() */
  @Inject
  private ProductRepository productRepository;

  /**
   * @return the {@link ProductRepository} instance.
   */
  public ProductRepository getProductRepository() {

    return this.productRepository;
  }

}
