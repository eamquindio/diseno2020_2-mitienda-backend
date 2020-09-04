package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.ShoppingCart;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Shopping cart repository
 */
@Component
public class ShoppingCartRepository {
  /**
   * Adding the persistence context
   */
  @PersistenceContext
  private EntityManager en;

  /**
   * shopping cart repository
   * @param shoppingCart , shopping cart
   */
  public void create(ShoppingCart shoppingCart) {
    en.persist(shoppingCart);
  }

  /**
   * shopping cart
   * @param id , id
   * @return , object
   */
  public ShoppingCart find(Long id) {
    return en.find(ShoppingCart.class, id);

  }

  /**
   * shopping cart
   * @param shoppingCart , shopping cart
   */
  public void edit(ShoppingCart shoppingCart) {
    en.merge(shoppingCart);
  }

  /**
   * shopping cart
   * @param id , id
   * @return , object
   */
  public ShoppingCart delete(Long id) {
    ShoppingCart shoppingCart = find(id);
    en.remove(shoppingCart);
    return shoppingCart;
  }
}
