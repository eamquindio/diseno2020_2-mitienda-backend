package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Class Shopping Cart Product
 */
@Entity
@Table(name = "shopping_cart_products")
public class ShoppingCartProduct implements Serializable {

  /**
   * Product Store Shopping Cart
   */
  @ManyToOne
  @JoinColumn(name = "id_product_store", referencedColumnName = "id")
  private ProductStore product;

  /**
   * Quantity Shopping Cart Product
   */
  private int quantity;

  /**
   * Construct Shopping Cart Product
   */
  public ShoppingCartProduct() {
  }
}
