package co.edu.eam.disenosoftware.homeautobackend.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Shopping Cart's class
 */
@Entity
@Table(name = "shopping_carts")
public class ShoppingCart implements Serializable {

  /**
<<<<<<< HEAD:src/main/java/co/edu/eam/disenosoftware/homeautobackend/model/entities/ShoppingCart.java
   * Shopping Cart's - Primary key
=======
   * Shopping cart´s primary key
>>>>>>> 216ac10... corrigiendo estructuracion del proyecto (carpetas y entidades):src/main/java/co/edu/eam/disenosoftware/homeauto/mode/entities/ShoppingCart.java
   */
  @Id
  private Long id;

  /**
   * Store of the shopping cart - Foreign key
   */
  @ManyToOne
  @JoinColumn(name = "id_store", referencedColumnName = "id")
  private Store store;

  /**
   * Shopping Cart's Product
   */
  @OneToMany(mappedBy = "shoppingCart")
  private List<ShoppingCartProduct> product;

  /**
   * User of the shopping cart - Foreign Key
   */
  @ManyToOne
  @JoinColumn(name = "id_user", referencedColumnName = "id")
  private User user;

  /**
<<<<<<< HEAD:src/main/java/co/edu/eam/disenosoftware/homeautobackend/model/entities/ShoppingCart.java
   * Shopping Cart's constructor
   */
  public ShoppingCart() {
  }
=======
   * Shopping cart´s constructor
   */
  public ShoppingCart() {
  }

>>>>>>> 216ac10... corrigiendo estructuracion del proyecto (carpetas y entidades):src/main/java/co/edu/eam/disenosoftware/homeauto/mode/entities/ShoppingCart.java
}
