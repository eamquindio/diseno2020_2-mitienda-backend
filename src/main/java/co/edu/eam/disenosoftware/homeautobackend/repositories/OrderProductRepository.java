package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.OrderProduct;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Order product repository
 */
@Component
public class OrderProductRepository {
  /**
   * adding persistence context
   */
  @PersistenceContext
  private EntityManager en;

  /**
   * order product
   * @param orderProduct , order product
   */
  public void create(OrderProduct orderProduct) {
    en.persist(orderProduct);
  }

  /**
   * order product
   * @param id , id
   * @return , object
   */
  public OrderProduct find(Long id) {
    return en.find(OrderProduct.class, id);

  }

  /**
   * order product
   * @param orderProduct , order product
   */
  public void edit(OrderProduct orderProduct) {
    en.merge(orderProduct);
  }

  /**
   * order product
   * @param id , id
   * @return , object
   */
  public OrderProduct delete(Long id) {
    OrderProduct orderProduct = find(id);
    en.remove(orderProduct);
    return orderProduct;
  }
}
