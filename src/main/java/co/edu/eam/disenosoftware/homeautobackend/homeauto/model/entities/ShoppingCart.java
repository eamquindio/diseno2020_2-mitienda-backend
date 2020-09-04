package co.edu.eam.disenosoftware.homeautobackend.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

/**
 * Entidad shoppingCart
 */
@Entity
@Table(name = "Shoppings_Cart")
public class ShoppingCart {

  /**
   * Primary Key
   */
  @Id
  private Long id;

  /**
   * ShoppingCart store
   */
  @ManyToOne
  @JoinColumn(name = "store_id", referencedColumnName = "id")
  private Store store;

  /**
   * List ShoppingCart product
   */
  private List<ShoppingCartProduct> product;

  /**
   * ShoppingCart user
   */
  private User user;

  /**
   * Constructor
   */
  public ShoppingCart() {
  }
}
