package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * entities shoppingCart
 */

@Entity
@Table(name = "tb_shoppingCart")
public class ShoppingCart implements Serializable {

  /**
   * id shoppingCart primary key
   */

  @Id
  @Column(name = "shoppingCart_id")
  private Long id;

  /**
   * shopping cart from the store
   */

  @Column(name = "shoppingCart_store")
  private Store store;

  /**
   * ShoppingCartProduct
   */

  @Column(name = "shoppingCart_product")
  private List<ShoppingCartProduct> product;

  /**
   * Store's name
   */

  @Column(name = "shoppingCart_user")
  private User user;

  /**
   * builder of the store
   */

  public ShoppingCart() {
  }
}
