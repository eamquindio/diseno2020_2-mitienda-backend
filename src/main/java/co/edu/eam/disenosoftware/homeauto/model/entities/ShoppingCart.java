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
 * class shopping cart
 */
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart implements Serializable {

  /**
   * id shopping cart
   */
  @Id
  private Long id;

  /**
   * mapped store
   */
  @ManyToOne
  @JoinColumn(name = "id_store", referencedColumnName = "id")
  private Store store;

  /**
   * mapped list product
   */
  @OneToMany(mappedBy = "product")
  private List<ShoppingCartProduct> product;

  /**
   * mapped user
   */
  @ManyToOne
  @JoinColumn(name = "id_user", referencedColumnName = "id")
  private User user;

  /**
   * builder shopping cart
   */
  public ShoppingCart() {
  }
}
