package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * Shopping cart product: class
 */
@Entity
@Table(name = "tb_shopping_cart_product")
public class ShoppingCartProduct implements Serializable {
  /**
   * Shopping cart product: product from store
   */
  @ManyToOne
  @JoinColumn(name = "product_store_id", referencedColumnName = "id")
  private ProductStore product;

  /**
   * Shopping cart product: quantity
   */
  @Column(name = "shopping_cart_product_quantity")
  private int quantity;

  /**
   * Shopping cart product: constructor
   */
  public ShoppingCartProduct() {

  }
}
