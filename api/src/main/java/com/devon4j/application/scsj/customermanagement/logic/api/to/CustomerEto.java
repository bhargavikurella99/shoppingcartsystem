package com.devon4j.application.scsj.customermanagement.logic.api.to;

import com.devon4j.application.scsj.customermanagement.common.api.Customer;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of Customer
 */
public class CustomerEto extends AbstractEto implements Customer {

  private static final long serialVersionUID = 1L;

  private String customerName;

  private String email;

  private String gender;

  private long mobileNumber;

  @Override
  public String getCustomerName() {

    return customerName;
  }

  @Override
  public void setCustomerName(String customerName) {

    this.customerName = customerName;
  }

  @Override
  public String getEmail() {

    return email;
  }

  @Override
  public void setEmail(String email) {

    this.email = email;
  }

  @Override
  public String getGender() {

    return gender;
  }

  @Override
  public void setGender(String gender) {

    this.gender = gender;
  }

  @Override
  public long getMobileNumber() {

    return mobileNumber;
  }

  @Override
  public void setMobileNumber(long mobileNumber) {

    this.mobileNumber = mobileNumber;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.customerName == null) ? 0 : this.customerName.hashCode());
    result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
    result = prime * result + ((this.gender == null) ? 0 : this.gender.hashCode());
    result = prime * result + ((Long) mobileNumber).hashCode();

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
    CustomerEto other = (CustomerEto) obj;
    if (this.customerName == null) {
      if (other.customerName != null) {
        return false;
      }
    } else if (!this.customerName.equals(other.customerName)) {
      return false;
    }
    if (this.email == null) {
      if (other.email != null) {
        return false;
      }
    } else if (!this.email.equals(other.email)) {
      return false;
    }
    if (this.gender == null) {
      if (other.gender != null) {
        return false;
      }
    } else if (!this.gender.equals(other.gender)) {
      return false;
    }
    if (this.mobileNumber != other.mobileNumber) {
      return false;
    }

    return true;
  }
}
