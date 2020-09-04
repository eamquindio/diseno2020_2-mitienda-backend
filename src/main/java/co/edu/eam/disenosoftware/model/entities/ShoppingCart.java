package co.edu.eam.disenosoftware.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Entities shoppingCart
 */

@Entity
@Table(name = "shoppingCarts")
public class ShoppingCart implements Serializable {

  /**
   * Id shoppingCart primary key
   */

  @Id
  private Long id;

  /**
   * shopping cart from the store
   */

  private Store store;

  /**
   * ShoppingCartProduct
   */

  @OneToMany(mappedBy = "shoppingCart")
  private List<ShoppingCartProduct> product;

  /**
   * Store's name
   */

  private User user;

  /**
   * builder of the store
   */

  public ShoppingCart() {
  }
}
