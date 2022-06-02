package com.devon4j.application.scsj.customermanagement.dataaccess.api;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.devon4j.application.scsj.customermanagement.common.api.Customer;
import com.devon4j.application.scsj.general.dataaccess.api.ApplicationPersistenceEntity;
import com.devon4j.application.scsj.productmanagement.dataaccess.api.ProductEntity;

/**
 * TODO bkurella This type ...
 */
@Entity
@Table(name = "Customer")
public class CustomerEntity extends ApplicationPersistenceEntity implements Customer {

  private String customerName;

  private String email;

  private String gender;

  private long mobileNumber;

  private List<ProductEntity> products;

  private static final long serialVersionUID = 1L;

  /**
   * The constructor.
   *
   * @param customerId
   * @param customerName
   * @param email
   * @param gender
   * @param mobileNumber
   * @param products
   */
  public CustomerEntity(String customerName, String email, String gender, long mobileNumber,
      List<ProductEntity> products) {

    super();
    this.customerName = customerName;
    this.email = email;
    this.gender = gender;
    this.mobileNumber = mobileNumber;
    this.products = products;
  }

  /**
   * The constructor.
   */
  public CustomerEntity() {

    super();
  }

  /**
   * @return customerName
   */
  public String getCustomerName() {

    return this.customerName;
  }

  /**
   * @param customerName new value of {@link #getcustomerName}.
   */
  public void setCustomerName(String customerName) {

    this.customerName = customerName;
  }

  /**
   * @return email
   */
  public String getEmail() {

    return this.email;
  }

  /**
   * @param email new value of {@link #getemail}.
   */
  public void setEmail(String email) {

    this.email = email;
  }

  /**
   * @return gender
   */
  public String getGender() {

    return this.gender;
  }

  /**
   * @param gender new value of {@link #getgender}.
   */
  public void setGender(String gender) {

    this.gender = gender;
  }

  /**
   * @return mobileNumber
   */
  public long getMobileNumber() {

    return this.mobileNumber;
  }

  /**
   * @param mobileNumber new value of {@link #getmobileNumber}.
   */
  public void setMobileNumber(long mobileNumber) {

    this.mobileNumber = mobileNumber;
  }

  /**
   * @return products
   */
  @OneToMany(mappedBy = "customer")
  public List<ProductEntity> getProducts() {

    return this.products;
  }

  /**
   * @param products new value of {@link #getproducts}.
   */
  public void setProducts(List<ProductEntity> products) {

    this.products = products;
  }

}
