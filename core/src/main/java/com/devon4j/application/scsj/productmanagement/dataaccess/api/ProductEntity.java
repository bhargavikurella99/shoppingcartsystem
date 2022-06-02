package com.devon4j.application.scsj.productmanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.devon4j.application.scsj.customermanagement.dataaccess.api.CustomerEntity;
import com.devon4j.application.scsj.general.dataaccess.api.ApplicationPersistenceEntity;
import com.devon4j.application.scsj.productmanagement.common.api.Product;

/**
 * TODO bkurella This type ...
 */
@Entity
@Table(name = "Product")
public class ProductEntity extends ApplicationPersistenceEntity implements Product {

  private String productName;

  private int quantity;

  private int price;

  private CustomerEntity customer;

  private static final long serialVersionUID = 1L;

  /**
   * The constructor.
   *
   * @param productName
   * @param quantity
   * @param price
   * @param customer
   */
  public ProductEntity(String productName, int quantity, int price, CustomerEntity customer) {

    super();
    this.productName = productName;
    this.quantity = quantity;
    this.price = price;
    this.customer = customer;
  }

  /**
   * The constructor.
   */
  public ProductEntity() {

    super();
  }

  /**
   * @return productName
   */
  public String getProductName() {

    return this.productName;
  }

  /**
   * @param productName new value of {@link #getproductName}.
   */
  public void setProductName(String productName) {

    this.productName = productName;
  }

  /**
   * @return quantity
   */
  public int getQuantity() {

    return this.quantity;
  }

  /**
   * @param quantity new value of {@link #getquantity}.
   */
  public void setQuantity(int quantity) {

    this.quantity = quantity;
  }

  /**
   * @return price
   */
  public int getPrice() {

    return this.price;
  }

  /**
   * @param price new value of {@link #getprice}.
   */
  public void setPrice(int price) {

    this.price = price;
  }

  /**
   * @return customer
   */
  @ManyToOne
  @JoinColumn(name = "idCustomer")
  public CustomerEntity getCustomer() {

    return this.customer;
  }

  /**
   * @param customer new value of {@link #getcustomer}.
   */
  public void setCustomer(CustomerEntity customer) {

    this.customer = customer;
  }

  @Transient
  public Long getCustomerId() {

    if (this.customer == null) {
      return null;
    }
    return this.customer.getId();
  }

  public void setCustomerId(Long customerId) {

    if (customerId == null) {
      this.customer = null;
    } else {
      CustomerEntity customerEntity = new CustomerEntity();
      customerEntity.setId(customerId);
      this.customer = customerEntity;
    }
  }

}
