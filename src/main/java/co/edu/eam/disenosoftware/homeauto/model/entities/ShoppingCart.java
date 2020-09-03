package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Shopping cart: class
 */
@Entity
@Table(name = "tb_shopping_cart")
public class ShoppingCart implements Serializable {

  /**
   * Shopping cart id
   */
  @Id
  @Column(name = "shopping_cart_id")
  private Long id;

  /**
   * Shopping cart: store
   */
  @ManyToOne
  @JoinColumn(name = "store_id", referencedColumnName = "id")
  private Store store;

  /**
   * Shopping cart: connection between Shopping cart to Shopping cart product
   */
  @OneToMany
  @JoinTable(name = "shopping_cart_to_shopping_cart_product",
          joinColumns = @JoinColumn(name = "shopping_cart"),
          inverseJoinColumns = @JoinColumn(name = "shopping_cart_product"))
  private List<ShoppingCartProduct> product;


  /**
   * Shopping cart: User
   */
  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;

  /**
   * Shopping cart: constructor
   */
  public ShoppingCart() {

  }
}
