package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.model.entities.ShoppingCart;
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
   * Add a product order
   *
   * @param shoppingCart product order to create
   */
  public void create(ShoppingCart shoppingCart) {

    em.persist(shoppingCart);

  }

  /**
   * Add a product order
   *
   * @param id primary key
   * @return a room or null if not exist
   */
  public ShoppingCart find(Long id) {

    ShoppingCart shoppingCart = em.find(ShoppingCart.class, id);


    return shoppingCart;

  }

  /**
   * Edit a shoppingCart
   *
   * @param shoppingCart shoppingCart to edit
   */
  public void edit(ShoppingCart shoppingCart) {

    em.merge(shoppingCart);

  }

  /**
   * Delete a  ShoppingCart
   *
   * @param id primary key
   * @return room deleted or null if not exists
   */
  public ShoppingCart delete(Long id) {

    ShoppingCart shoppingCart = find(id);

    if (shoppingCart != null) {

      em.remove(shoppingCart);

    }

    return shoppingCart;

  }

  /**
   * A function for list all shoppingCart
   *
   * @param idUser  parameter to evaluate
   * @param idStore parameter to evaluate
   * @return List shoppingCart
   */
  public List<ShoppingCart> getAlShoppingCartByUserIdAndStoreId(Long idUser, Long idStore) {
    String queryStr = "SELECT shopping FROM ShoppingCart shopping "
            + " WHERE shopping.user.id = :userId AND shopping.store.id = :storeId";
    Query query = em.createQuery(queryStr);
    query.setParameter("userId", idUser);
    query.setParameter("storeId", idStore);

    return query.getResultList();
  }

}
