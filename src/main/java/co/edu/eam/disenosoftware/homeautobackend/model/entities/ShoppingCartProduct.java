package co.edu.eam.disenosoftware.homeautobackend.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Class Shopping Card Product
 */
@Entity
@Table(name = "shopping_cart_products")
public class ShoppingCartProduct implements Serializable {

  /**
   * ID product Store
   */
  @ManyToOne
  @JoinColumn(name = "id_product_store", referencedColumnName = "id")
  private ProductStore product;

  /**
   * quantity Shopping Cart Product
   */
  private int quantity;


  /**
   * ID ShoppingCardProduct
   */
  @Id
  private Long id;

  /**
   * Constructor Shopping Cart Product
   */

  public ShoppingCartProduct() {
  }
}
