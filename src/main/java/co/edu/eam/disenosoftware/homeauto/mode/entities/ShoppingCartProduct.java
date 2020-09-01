package co.edu.eam.disenosoftware.homeauto.mode.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Shopping cart's product class
 */
@Entity
@Table(name = "shopping_cart_products")
public class ShoppingCartProduct implements Serializable {

  /**
   * Shopping cart's product constructor
   */
  public ShoppingCartProduct() {
  }

  /**
   * Shopping cart's products primary key
   */
  @Id
  private Long id;

  /**
   * product´s shopping cart
   */
  @ManyToOne
  @JoinColumn(name = "id_shopping_cart", referencedColumnName = "id")
  private ShoppingCart shoppingCart;

  /**
   * Shopping cart's product
   */
  @ManyToOne
  @JoinColumn(name = "id_product_store", referencedColumnName = "id")
  private ProductStore product;

  /**
   * Shopping cart's product's quantity
   */
  private int quantity;

}
