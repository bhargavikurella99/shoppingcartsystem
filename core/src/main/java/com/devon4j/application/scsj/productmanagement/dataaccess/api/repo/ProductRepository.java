package com.devon4j.application.scsj.productmanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.devon4j.application.scsj.productmanagement.dataaccess.api.ProductEntity;
import com.devon4j.application.scsj.productmanagement.logic.api.to.ProductSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link ProductEntity}
 */
public interface ProductRepository extends DefaultRepository<ProductEntity> {

  /**
   * @param criteria the {@link ProductSearchCriteriaTo} with the criteria to search.
   * @return the {@link Page} of the {@link ProductEntity} objects that matched the search. If no pageable is set, it
   *         will return a unique page with all the objects that matched the search.
   */
  default Page<ProductEntity> findByCriteria(ProductSearchCriteriaTo criteria) {

    ProductEntity alias = newDslAlias();
    JPAQuery<ProductEntity> query = newDslQuery(alias);

    String productName = criteria.getProductName();
    if (productName != null && !productName.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getProductName()), productName, criteria.getProductNameOption());
    }
    Integer quantity = criteria.getQuantity();
    if (quantity != null) {
      query.where($(alias.getQuantity()).eq(quantity));
    }
    Integer price = criteria.getPrice();
    if (price != null) {
      query.where($(alias.getPrice()).eq(price));
    }
    Long customer = criteria.getCustomerId();
    if (customer != null) {
      query.where($(alias.getCustomer().getId()).eq(customer));
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
  public default void addOrderBy(JPAQuery<ProductEntity> query, ProductEntity alias, Sort sort) {

    if (sort != null && sort.isSorted()) {
      Iterator<Order> it = sort.iterator();
      while (it.hasNext()) {
        Order next = it.next();
        switch (next.getProperty()) {
          case "productName":
            if (next.isAscending()) {
              query.orderBy($(alias.getProductName()).asc());
            } else {
              query.orderBy($(alias.getProductName()).desc());
            }
            break;
          case "quantity":
            if (next.isAscending()) {
              query.orderBy($(alias.getQuantity()).asc());
            } else {
              query.orderBy($(alias.getQuantity()).desc());
            }
            break;
          case "price":
            if (next.isAscending()) {
              query.orderBy($(alias.getPrice()).asc());
            } else {
              query.orderBy($(alias.getPrice()).desc());
            }
            break;
          case "customer":
            if (next.isAscending()) {
              query.orderBy($(alias.getCustomer().getId().toString()).asc());
            } else {
              query.orderBy($(alias.getCustomer().getId().toString()).desc());
            }
            break;
          default:
            throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
        }
      }
    }
  }

}