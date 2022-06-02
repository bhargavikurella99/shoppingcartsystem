package com.devon4j.application.scsj.productmanagement.logic.api.to;

import com.devon4j.application.scsj.general.common.api.to.AbstractSearchCriteriaTo;
import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

/**
 * {@link SearchCriteriaTo} to find instances of
 * {@link com.devon4j.application.scsj.productmanagement.common.api.Product}s.
 */
public class ProductSearchCriteriaTo extends AbstractSearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String productName;

  private Integer quantity;

  private Integer price;

  private Long customerId;

  private StringSearchConfigTo productNameOption;

  /**
   * @return productNameId
   */

  public String getProductName() {

    return productName;
  }

  /**
   * @param productName setter for productName attribute
   */

  public void setProductName(String productName) {

    this.productName = productName;
  }

  /**
   * @return quantityId
   */

  public Integer getQuantity() {

    return quantity;
  }

  /**
   * @param quantity setter for quantity attribute
   */

  public void setQuantity(Integer quantity) {

    this.quantity = quantity;
  }

  /**
   * @return priceId
   */

  public Integer getPrice() {

    return price;
  }

  /**
   * @param price setter for price attribute
   */

  public void setPrice(Integer price) {

    this.price = price;
  }

  /**
   * getter for customerId attribute
   * 
   * @return customerId
   */

  public Long getCustomerId() {

    return customerId;
  }

  /**
   * @param customer setter for customer attribute
   */

  public void setCustomerId(Long customerId) {

    this.customerId = customerId;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getProductName() productName}.
   */
  public StringSearchConfigTo getProductNameOption() {

    return this.productNameOption;
  }

  /**
   * @param productNameOption new value of {@link #getProductNameOption()}.
   */
  public void setProductNameOption(StringSearchConfigTo productNameOption) {

    this.productNameOption = productNameOption;
  }

}
