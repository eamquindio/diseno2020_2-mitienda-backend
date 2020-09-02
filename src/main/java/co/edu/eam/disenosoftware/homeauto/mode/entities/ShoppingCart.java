package co.edu.eam.disenosoftware.homeauto.mode.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Shopping cart´s class
 */
@Entity
@Table(name = "shopping_carts")
public class ShoppingCart implements Serializable {

  /**
   * Shopping cart´s constructor
   */
  public ShoppingCart() {
  }

  /**
   * Shopping cart´s primary key
   */
  @Id
  private Long id;

  /**
   * Shopping cart´s store
   */
  @ManyToOne
  @JoinColumn(name = "id_store", referencedColumnName = "id")
  private Store store;

  /**
   * Shopping cart´s list of products
   */
  @OneToMany(mappedBy = "shoppingCart")
  private List<ShoppingCartProduct> products;

  /**
   * Shopping cart´s user (owner)
   */
  @ManyToOne
  @JoinColumn(name = "id_user", referencedColumnName = "id")
  private User user;

}
