package co.edu.eam.disenosoftware.homeautobackend.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shopping_cart_products")
public class ShoppingCartProduct {

  /**
   * ShoppingCartProduct product
   */
  @ManyToOne
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private ProductStore product;

  /**
   * ShoppingCartProduct quantity
   */
  private int quantity;

  /**
   * Constructor
   */
  public ShoppingCartProduct() {
  }
}
