package co.edu.eam.disenosoftware.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entities shoppingCartProduct
 */

@Entity
@Table(name = "shoppingCartProducts")
public class ShoppingCartProduct implements Serializable {

  /**
   * Id primary key
   */
  @Id
  private Long id;

  /**
   * shoppingCartProduct
   */

  private ProductStore product;

  /**
   * quantity shoppingCartProduct
   */

  private int quantity;

  /**
   * shoppingCartProduct builder
   */

  @ManyToOne
  @JoinColumn(name = "id_product", referencedColumnName = "id")
  private ProductStore productStore;

  /**
   * ManyToOne shoppingCart
   */
  @ManyToOne
  @JoinColumn(name = "id_shoppingCart", referencedColumnName = "id")
  private ShoppingCart shoppingCart;

  public ShoppingCartProduct() {
  }
}
