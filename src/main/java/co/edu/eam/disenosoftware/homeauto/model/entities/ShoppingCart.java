package co.edu.eam.disenosoftware.homeauto.model.entities;

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
   * Shopping Cart's primary key
   */
  @Id
  private String id;

  /**
   * Store of the shopping cart - Foreign key
   */
  @ManyToOne
  @JoinColumn(name = "id_store", referencedColumnName = "id")
  private Store store;

  /**
   * Shopping Cart's Product
   */
  @OneToMany(mappedBy ="product")
  private List<ShoppingCartProduct> product;

  /**
   * User of the shopping cart - Foreign Key
   */
  @ManyToOne
  @JoinColumn(name = "id_user", referencedColumnName = "id")
  private User user;

  /**
   * Shopping Cart's constructor
   */
  public ShoppingCart() {
  }

}
