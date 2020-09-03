package co.edu.eam.disenosoftware.homeautobackend.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ShoppingCartProducts")
public class ShoppingCartProduct {

  /**
   * ShoppingCartProduct product
   */
  @ManyToOne
  @JoinColumn(name = "product", referencedColumnName = "id")
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
