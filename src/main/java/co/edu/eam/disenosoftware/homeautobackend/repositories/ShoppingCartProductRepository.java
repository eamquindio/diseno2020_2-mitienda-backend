package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.ShoppingCartProduct;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Shopping cart product repository
 */
@Component
public class ShoppingCartProductRepository {
  /**
   * Adding persistence context
   */
  @PersistenceContext
  private EntityManager en;

  /**
   * shopping cart product
   * @param shoppingCartProduct , shopping cart product
   */
  public void create(ShoppingCartProduct shoppingCartProduct) {
    en.persist(shoppingCartProduct);
  }

  /**
   * shopping cart product
   * @param id , id
   * @return , object
   */
  public ShoppingCartProduct find(Long id) {
    return en.find(ShoppingCartProduct.class, id);

  }

  /**
   * shopping cart product
   * @param shoppingCartProduct , object
   */

  public void edit(ShoppingCartProduct shoppingCartProduct) {
    en.merge(shoppingCartProduct);
  }

  /**
   * shopping cart product
   * @param id , id
   * @return , object
   */
  public ShoppingCartProduct delete(Long id) {
    ShoppingCartProduct shoppingCartProduct = find(id);
    en.remove(shoppingCartProduct);
    return shoppingCartProduct;
  }
}
