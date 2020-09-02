package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * entities shoppingCartProduct
 */

@Entity
@Table(name = "tb_shoppingCartProduct")
public class ShoppingCartProduct implements Serializable {

  /**
   * shoppingCartProduct
   */

  @Column(name = "shoppingCartProduct_product")
  private ProductStore product;

  /**
   * quantity shoppingCartProduct
   */

  @Column(name = "shoppingCartProduct_quantity")
  private int quantity;

  /**
   * shoppingCartProduct builder
   */

  public ShoppingCartProduct() {
  }
}
