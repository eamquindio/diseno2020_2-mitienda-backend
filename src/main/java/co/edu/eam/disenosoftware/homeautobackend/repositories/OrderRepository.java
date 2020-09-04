package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.Order;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * order repository
 */
@Component
public class OrderRepository {
  /**
   * adding persistence context
   */
  @PersistenceContext
  private EntityManager en;

  /**
   * order
   * @param order , order
   */
  public void create(Order order) {
    en.persist(order);
  }

  /**
   * order
   * @param id , id
   * @return , object
   */
  public Order find(Long id) {
    return en.find(Order.class, id);

  }

  /**
   * order
   * @param order , order
   */
  public void edit(Order order) {
    en.merge(order);
  }

  /**
   * order
   * @param id , id
   * @return , object
   */
  public Order delete(Long id) {
    Order order = find(id);
    en.remove(order);
    return order;
  }
}
