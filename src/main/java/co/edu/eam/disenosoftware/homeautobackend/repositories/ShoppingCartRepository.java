package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.ShoppingCart;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * shopping cart Repository
 */
@Component
@Transactional
public class ShoppingCartRepository {

  /**
   * EntityManager
   */
  @PersistenceContext
  private EntityManager em;

  /**
   * A function for list all shoppingCart
   * @param idUser parameter to evaluate
   * @param idStore parameter to evaluate
   * @return List shoppingCart
   */
  private List<ShoppingCart> getAlShoppingCartByUser(Long idUser, Long idStore) {
    String queryStr = "SELECT shopping FROM ShoppingCart shopping "
            + " WHERE shopping.user.id = :userId AND shopping.store.id = :storeId";
    Query query = em.createQuery(queryStr);
    query.setParameter("userId", idUser);
    query.setParameter("storeId", idStore);

    return query.getResultList();
  }
}
