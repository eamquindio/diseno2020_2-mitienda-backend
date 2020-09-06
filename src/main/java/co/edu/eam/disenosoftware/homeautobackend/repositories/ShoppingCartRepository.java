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
   *Add a product order
   * @param shoppingCartRepository product order to create
   */
  public void create(ShoppingCartRepository shoppingCartRepository) {

    em.persist(shoppingCartRepository);

  }

  /**
   *Add a product order
   * @param id primary key
   * @return a room or null if not exist
   *
   */
  public ShoppingCartRepository find(Long id) {

    return em.find(ShoppingCartRepository.class, id);

  }

  /**
   * Edit a shoppingCartRepository
   * @param shoppingCartRepository shoppingCartRepository to edit
   */
  public void edit(ShoppingCartRepository shoppingCartRepository) {

    em.merge(shoppingCartRepository);

  }

  /**
   *Delete a room
   * @param id primary key
   * @return room deleted or null if not exists
   *
   */
  public ShoppingCartRepository delete(Long id) {

    ShoppingCartRepository shoppingCartRepository = find(id);

    em.remove(shoppingCartRepository);

    return shoppingCartRepository;
  }

  /**
   * A function for list all shoppingCart
   * @param idUser parameter to evaluate
   * @param idStore parameter to evaluate
   * @return List shoppingCart
   */
  private List<ShoppingCart> getAlShoppingCartByUserIdAndStoreId(Long idUser, Long idStore) {
    String queryStr = "SELECT shopping FROM ShoppingCart shopping "
            + " WHERE shopping.user.id = :userId AND shopping.store.id = :storeId";
    Query query = em.createQuery(queryStr);
    query.setParameter("userId", idUser);
    query.setParameter("storeId", idStore);

    return query.getResultList();
  }

}
