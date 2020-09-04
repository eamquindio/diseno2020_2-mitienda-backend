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
 * Class Shopping Cart
 */
@Entity
@Table(name = "shopping_carts")
public class ShoppingCart implements Serializable {

  /**
   * ID store
   */
  @ManyToOne
  @JoinColumn(name = "id_store", referencedColumnName = "id")
  private Store store;

  /**
   * Product Shopping Cart
   */
  @OneToMany(mappedBy = "product")
  private List<ShoppingCartProduct> product;

  /**
   * ID user
   */
  @ManyToOne
  @JoinColumn(name = "id_user", referencedColumnName = "id")
  private User user;

  /**
   * ID Shopping Cart
   */
  @Id
  private Long id;

  /**
   * Constructor Shopping Store
   */
  public ShoppingCart() {
  }
}
