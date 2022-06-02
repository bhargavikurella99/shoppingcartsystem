package com.devon4j.application.scsj.productmanagement.common.api;

import com.devon4j.application.scsj.general.common.api.ApplicationEntity;

public interface Product extends ApplicationEntity {

  /**
   * @return productNameId
   */

  public String getProductName();

  /**
   * @param productName setter for productName attribute
   */

  public void setProductName(String productName);

  /**
   * @return quantityId
   */

  public int getQuantity();

  /**
   * @param quantity setter for quantity attribute
   */

  public void setQuantity(int quantity);

  /**
   * @return priceId
   */

  public int getPrice();

  /**
   * @param price setter for price attribute
   */

  public void setPrice(int price);

  /**
   * getter for customerId attribute
   * 
   * @return customerId
   */

  public Long getCustomerId();

  /**
   * @param customer setter for customer attribute
   */

  public void setCustomerId(Long customerId);

}
