package com.devon4j.application.scsj.productmanagement.logic.api.to;

import com.devon4j.application.scsj.productmanagement.common.api.Product;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of Product
 */
public class ProductEto extends AbstractEto implements Product {

  private static final long serialVersionUID = 1L;

  private String productName;

  private int quantity;

  private int price;

  private Long customerId;

  @Override
  public String getProductName() {

    return productName;
  }

  @Override
  public void setProductName(String productName) {

    this.productName = productName;
  }

  @Override
  public int getQuantity() {

    return quantity;
  }

  @Override
  public void setQuantity(int quantity) {

    this.quantity = quantity;
  }

  @Override
  public int getPrice() {

    return price;
  }

  @Override
  public void setPrice(int price) {

    this.price = price;
  }

  @Override
  public Long getCustomerId() {

    return customerId;
  }

  @Override
  public void setCustomerId(Long customerId) {

    this.customerId = customerId;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.productName == null) ? 0 : this.productName.hashCode());
    result = prime * result + ((Integer) quantity).hashCode();
    result = prime * result + ((Integer) price).hashCode();

    result = prime * result + ((this.customerId == null) ? 0 : this.customerId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    ProductEto other = (ProductEto) obj;
    if (this.productName == null) {
      if (other.productName != null) {
        return false;
      }
    } else if (!this.productName.equals(other.productName)) {
      return false;
    }
    if (this.quantity != other.quantity) {
      return false;
    }
    if (this.price != other.price) {
      return false;
    }

    if (this.customerId == null) {
      if (other.customerId != null) {
        return false;
      }
    } else if (!this.customerId.equals(other.customerId)) {
      return false;
    }
    return true;
  }
}
