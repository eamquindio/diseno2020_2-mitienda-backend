package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

/**
 * Class Shopping Cart
 */
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart implements Serializable {

  /**
   * Id Shopping Cart
   */
  @Id
  private String id;

  /**
   * Store Shopping Cart
   */
  @ManyToOne
  @JoinColumn(name = "id_store", referencedColumnName = "id")
  private Store store;

  /**
   * List Products Shopping Cart
   */
  @OneToMany(mappedBy = "product")
  private List<ShoppingCartProduct> product;

  /**
   * User Shopping Cart
   */
  @ManyToOne
  @JoinColumn(name = "id_user", referencedColumnName = "id")
  private User user;

  /**
   * Construct Shopping Cart
   */
  public ShoppingCart() {
  }
}
