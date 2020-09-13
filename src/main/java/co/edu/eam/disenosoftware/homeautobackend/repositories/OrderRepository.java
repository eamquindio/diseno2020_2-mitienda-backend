package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Orders Repository
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
   * Method to find current orders for a specific user
   * @param idUser User id parameter
   * @return List of current orders for a specific user
   */
  public List<Order> getOrdersInCourseByUserId(Long idUser) {
    String queryStr = "SELECT order FROM Order order WHERE order.user.id = :id "
            + "AND order.state = in_progress OR order.state = created";
    Query query = em.createQuery(queryStr);
    query.setParameter("id", idUser);
    return query.getResultList();
  }
}
