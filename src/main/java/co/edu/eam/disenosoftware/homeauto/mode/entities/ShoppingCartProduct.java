package co.edu.eam.disenosoftware.homeauto.mode.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "shopping_cart_products")
public class ShoppingCartProduct implements Serializable {

  public ShoppingCartProduct() {
  }

  @ManyToOne
  @JoinColumn(name = "id_shopping_cart",referencedColumnName = "id")
  private ShoppingCart shoppingCart;

  @ManyToOne
  @JoinColumn(name = "id_product_store", referencedColumnName = "id")
  private ProductStore product;

  private int quantity;

}
