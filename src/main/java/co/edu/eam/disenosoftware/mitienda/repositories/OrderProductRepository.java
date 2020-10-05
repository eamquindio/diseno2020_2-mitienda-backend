package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.model.entities.OrderProduct;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.Query;

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
   * Add a product order
   *
   * @param orderProduct product order to create
   */
  public void create(OrderProduct orderProduct) {
    em.persist(orderProduct);
  }

  /**
   * find a order product
   *
   * @param id primary key
   * @return a product order or a null if it doesn't exist
   */
  public OrderProduct find(Long  id) {
    return em.find(OrderProduct.class, id);
  }

  public List<OrderProduct> getOrderInOrderProduct() {
    String queryStr = "SELECT l FROM OrderProduct l";
    Query query = em.createQuery(queryStr);

    return query.getResultList();
  }

  public OrderProduct getOrderProductByState(Long id) {
    String queryStr = "SELECT op FROM OrderProduct op.id = :value WHERE op.id.state == 'PENDING' OR  op.id.state == 'CHECKED'";
    Query query = em.createQuery(queryStr);
    query.setParameter("value",id);

    List<OrderProduct> list = query.getResultList();

    if (list.size() != 0){
      return list.get(0);
    }else{
      return null;
    }
  }


  /**
   * edit a product order
   *
   * @param orderProduct product order to edit
   */
  public void edit(OrderProduct orderProduct) {
    em.merge(orderProduct);
  }

  /**
   * delete a order product
   *
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

  /**
   * delete a order product
   *
   * @param idOrder primary key order
   * @return list of orderProducts by idOrder
   */
  public List<OrderProduct> getAllOrderProductsByIdOrder(Long idOrder) {
    List<OrderProduct> orderProducts = em.createQuery("SELECT op FROM OrderProduct op WHERE op.order.id =:value")
            .setParameter("value", idOrder)
            .getResultList();
    return orderProducts;
  }
}
