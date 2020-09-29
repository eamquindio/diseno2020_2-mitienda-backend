package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.model.entities.ShoppingCartProduct;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * shopping cart product Repository
 */
@Component
@Transactional
public class ShoppingCartProductRepository {

  /**
   * EntityManager
   */
  @PersistenceContext
  private EntityManager em;

  /**
   * Add a product to the Shopping Cart
   *
   * @param shoppingCartProduct , Shopping Cart Product to create
   */
  public void create(ShoppingCartProduct shoppingCartProduct) {
    em.persist(shoppingCartProduct);
  }

  /**
   * Find a Shopping cart Product
   *
   * @param id , Primary Key
   * @return a Shopping Cart Product or null if doesn't exist
   */
  public ShoppingCartProduct find(Long id) {
    return em.find(ShoppingCartProduct.class, id);
  }

  /**
   * Edit a Shopping cart Product
   *
   * @param shoppingCartProduct , Shopping Cart Product to edit
   */
  public void edit(ShoppingCartProduct shoppingCartProduct) {
    em.merge(shoppingCartProduct);
  }

  /**
   * Delete a Shopping cart Product
   *
   * @param id , Primary Key
   * @return Shopping Cart Product deleted or null if doesn't exist
   */
  public ShoppingCartProduct delete(Long id) {
    ShoppingCartProduct shoppingCartProduct = find(id);
    if (shoppingCartProduct != null) {
      em.remove(shoppingCartProduct);
    }
    return shoppingCartProduct;
  }

  /**
   * Get all shopping cart products
   * @param idShoppingCart , Identifier Shopping Cart's
   * @return List of shopping cart products of the Shopping Cart's with the id that has been sent
   */
  public List<ShoppingCartProduct> getShoppingCartProductsByShoppingCartId(Long idShoppingCart) {
    String queryStr = "SELECT scp FROM ShoppingCartProduct scp WHERE "
            + " scp.shoppingCart.id = :id";
    Query query = em.createQuery(queryStr);
    query.setParameter("id", idShoppingCart);
    return query.getResultList();
  }

}
