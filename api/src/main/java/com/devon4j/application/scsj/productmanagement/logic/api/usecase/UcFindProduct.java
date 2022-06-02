package com.devon4j.application.scsj.productmanagement.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.devon4j.application.scsj.productmanagement.logic.api.to.ProductEto;
import com.devon4j.application.scsj.productmanagement.logic.api.to.ProductSearchCriteriaTo;

public interface UcFindProduct {

  /**
   * Returns a Product by its id 'id'.
   *
   * @param id The id 'id' of the Product.
   * @return The {@link ProductEto} with id 'id'
   */
  ProductEto findProduct(long id);

  /**
   * Returns a paginated list of Products matching the search criteria.
   *
   * @param criteria the {@link ProductSearchCriteriaTo}.
   * @return the {@link List} of matching {@link ProductEto}s.
   */
  Page<ProductEto> findProducts(ProductSearchCriteriaTo criteria);

}
