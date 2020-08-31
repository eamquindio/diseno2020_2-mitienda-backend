package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Shopping cart: class
 */
@Entity
@Table(name = "tb_shopping_cart")
public class ShoppingCart {

  /**
   * Shopping cart id
   */
  @Id
  @Column(name = "shopping_cart_id")
  private String id;

  /**
   * Shopping cart: store
   */
  @ManyToOne
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private Store store;

  /**
   * Shopping cart: store
   */
  @OneToMany
  @JoinTable(name = "shopping_cart_to_shopping_cart_product",
          joinColumns = @JoinColumn(name = "shopping_cart"),
          inverseJoinColumns = @JoinColumn(name = "shopping_cart_product"))
  private List<ShoppingCartProduct> product;


  /**
   * Shopping cart: store
   */
  @Column(name = "shopping_cart_user")
  private User user;

  /**
   * Shopping cart: constructor
   */
  public ShoppingCart() {

  }
}
