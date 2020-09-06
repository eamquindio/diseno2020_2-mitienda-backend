package co.edu.eam.disenosoftware.homeautobackend.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 Entity table shopping cart product
 */
@Entity
/**
 Table's name
 */
@Table(name = "shopping_cart_products")
public class ShoppingCartProduct implements Serializable {

  /**
   Prime key
   */
  @Id
  private String code;

  /**
   relation with entity product store
   */
  @ManyToOne
  @JoinColumn(name = "id_product_store", referencedColumnName = "code")
  private ProductStore productStore;

  /**
   quantity of shopping cart product
   */
  private int quantity;

  /**
   Relation one to many with shopping cart
   */
  @ManyToOne
  @JoinColumn(name = "id_shopping_cart", referencedColumnName = "id")
  private ShoppingCart shoppingCart;

  /**
   builder of entity
   */
  public ShoppingCartProduct() {
  }
}