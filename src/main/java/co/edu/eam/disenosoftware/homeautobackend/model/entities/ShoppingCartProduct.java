package co.edu.eam.disenosoftware.homeautobackend.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Shopping Cart's Product class
 */
@Entity
@Table(name = "shopping_cart_products")
public class ShoppingCartProduct implements Serializable {

  /**
<<<<<<< HEAD:src/main/java/co/edu/eam/disenosoftware/homeautobackend/model/entities/ShoppingCartProduct.java
   * Shopping Cart's Product's - Primary key
=======
   * Shopping cart's products primary key
>>>>>>> 216ac10... corrigiendo estructuracion del proyecto (carpetas y entidades):src/main/java/co/edu/eam/disenosoftware/homeauto/mode/entities/ShoppingCartProduct.java
   */
  @Id
  private Long id;

  /**
   * Shopping cart of the product shopping cart's - Foreign Key
   */
  @ManyToOne
  @JoinColumn(name = "id_shopping_cart", referencedColumnName = "id")
  private ShoppingCart shoppingCart;

  /**
   * Shopping Cart's Product
   */
  @ManyToOne
  @JoinColumn(name = "id_product_store", referencedColumnName = "id")
  private ProductStore product;

  /**
   * Shopping Cart's Product quantity
   */
  private int quantity;

  /**
<<<<<<< HEAD:src/main/java/co/edu/eam/disenosoftware/homeautobackend/model/entities/ShoppingCartProduct.java
   * Shopping Cart's Product constructor
   */
  public ShoppingCartProduct() {
  }
=======
   * Shopping cart's product constructor
   */
  public ShoppingCartProduct() {
  }

>>>>>>> 216ac10... corrigiendo estructuracion del proyecto (carpetas y entidades):src/main/java/co/edu/eam/disenosoftware/homeauto/mode/entities/ShoppingCartProduct.java
}
