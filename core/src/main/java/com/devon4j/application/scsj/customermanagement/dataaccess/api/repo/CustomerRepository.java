package com.devon4j.application.scsj.customermanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.devon4j.application.scsj.customermanagement.dataaccess.api.CustomerEntity;
import com.devon4j.application.scsj.customermanagement.logic.api.to.CustomerSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link CustomerEntity}
 */
public interface CustomerRepository extends DefaultRepository<CustomerEntity> {

  /**
   * @param criteria the {@link CustomerSearchCriteriaTo} with the criteria to search.
   * @return the {@link Page} of the {@link CustomerEntity} objects that matched the search. If no pageable is set, it
   *         will return a unique page with all the objects that matched the search.
   */
  default Page<CustomerEntity> findByCriteria(CustomerSearchCriteriaTo criteria) {

    CustomerEntity alias = newDslAlias();
    JPAQuery<CustomerEntity> query = newDslQuery(alias);

    String customerName = criteria.getCustomerName();
    if (customerName != null && !customerName.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getCustomerName()), customerName, criteria.getCustomerNameOption());
    }
    String email = criteria.getEmail();
    if (email != null && !email.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getEmail()), email, criteria.getEmailOption());
    }
    String gender = criteria.getGender();
    if (gender != null && !gender.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getGender()), gender, criteria.getGenderOption());
    }
    Long mobileNumber = criteria.getMobileNumber();
    if (mobileNumber != null) {
      query.where($(alias.getMobileNumber()).eq(mobileNumber));
    }
    if (criteria.getPageable() == null) {
      criteria.setPageable(PageRequest.of(0, Integer.MAX_VALUE));
    } else {
      addOrderBy(query, alias, criteria.getPageable().getSort());
    }

    return QueryUtil.get().findPaginated(criteria.getPageable(), query, true);
  }

  /**
   * Add sorting to the given query on the given alias
   * 
   * @param query to add sorting to
   * @param alias to retrieve columns from for sorting
   * @param sort specification of sorting
   */
  public default void addOrderBy(JPAQuery<CustomerEntity> query, CustomerEntity alias, Sort sort) {

    if (sort != null && sort.isSorted()) {
      Iterator<Order> it = sort.iterator();
      while (it.hasNext()) {
        Order next = it.next();
        switch (next.getProperty()) {
          case "customerName":
            if (next.isAscending()) {
              query.orderBy($(alias.getCustomerName()).asc());
            } else {
              query.orderBy($(alias.getCustomerName()).desc());
            }
            break;
          case "email":
            if (next.isAscending()) {
              query.orderBy($(alias.getEmail()).asc());
            } else {
              query.orderBy($(alias.getEmail()).desc());
            }
            break;
          case "gender":
            if (next.isAscending()) {
              query.orderBy($(alias.getGender()).asc());
            } else {
              query.orderBy($(alias.getGender()).desc());
            }
            break;
          case "mobileNumber":
            if (next.isAscending()) {
              query.orderBy($(alias.getMobileNumber()).asc());
            } else {
              query.orderBy($(alias.getMobileNumber()).desc());
            }
            break;
          default:
            throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
        }
      }
    }
  }

}