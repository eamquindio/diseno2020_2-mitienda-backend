package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * ORders Repository
 */
@Component
@Transactional
public class OrderRepository {

  /**
   * EntityManager
   */
  @PersistenceContext
  private EntityManager em;

  /**
   * Create a order
   *
   * @param order order to Create.
   */
  public void create(Order order) {
    em.persist(order);
  }

  /**
   * Find a order by primary key
   *
   * @param id primary key
   * @return a order or null if not exists
   */
  public Order find(Long id) {
    return em.find(Order.class, id);
  }

  /**
   * Edit a order
   *
   * @param order order to Edit.
   */
  public void edit(Order order) {
    em.merge(order);
  }

  /**
   * Delete a order
   *
   * @param id primary key
   * @return a order or null if not exists
   */
  public Order delete(Long id) {
    Order order = find(id);
    if (order != null) {
      em.remove(order);
    }
    return order;
  }


  /**
   * Method to find current orders for a specific user
   * @param idUser User id parameter
   * @return List of current orders for a specific user
   */
  public List<Order> getOrdersInCourseByUserId(Long idUser) {
    String queryStr = "SELECT order FROM Order order WHERE "
            + "order.user.id = :id AND order.state = 'in_progress' "
            + "OR order.user.id = :id AND order.state = 'created'";
    Query query = em.createQuery(queryStr);
    query.setParameter("id", idUser);
    return query.getResultList();
  }

  /**
   *Method to find the finishs' orders
   *@param id prime key of the user
   *@return list of orders finished from one user
   */
  public List<Order> getFinishedOrdersByUserId(Long id) {
    String quertyStr = "SELECT order FROM Order order WHERE order.state = 'finished' AND order.user.id = :value";
    Query query = em.createQuery(quertyStr);
    query.setParameter("value", id);
    return query.getResultList();
  }

}
