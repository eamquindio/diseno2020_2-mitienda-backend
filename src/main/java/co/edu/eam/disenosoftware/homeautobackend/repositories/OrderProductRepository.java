package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.OrderProduct;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * OrderProduct Repository
 */
@Component
@Transactional
public class OrderProductRepository {

  /**
   * EntityManager
   */
  @PersistenceContext
  private EntityManager em;

  /**
   *Add a product order
   * @param orderProduct product order to create
   */
  public void create(OrderProduct orderProduct) {
    em.persist(orderProduct);
  }

  /**
   * find a order product
   * @param id primary key
   * @return a product order or a null if it doesn't exist
   */
  public OrderProduct find(Long id) {
    return em.find(OrderProduct.class, id);
  }

  /**
   * edit a product order
   * @param orderProduct product order to edit
   */
  public void edit(OrderProduct orderProduct) {
    em.merge(orderProduct);
  }

  /**
   * delete a order product
   * @param id primary key
   * @return a product order or a null if it doesn't exist
   */
  public OrderProduct delete(Long id) {
    OrderProduct orderProduct = find(id);
    if (orderProduct != null) {
      em.remove(orderProduct);
    }
    return orderProduct;
  }
}
