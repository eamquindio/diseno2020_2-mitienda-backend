package co.edu.eam.disenosoftware.homeauto.mode.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "shopping_carts")
/**
 * Shopping cart´s class
 */
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
  private String id;

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
  @JoinColumn(name = "id:user", referencedColumnName = "id")
  private User user;

}
