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
 Entity table shopping cart
 */
@Entity
/**
 Table's name
 */
@Table(name = "shoppings_carts")
public class ShoppingCart implements Serializable {

  /**
   Prime key
   */
  @Id
  private String id;

  /**
   Relation with store
   */
  @ManyToOne
  @JoinColumn(name = "store_id", referencedColumnName = "id")
  private Store store;

  /**
   Relation one to many with a list of shopping cart product
   */
  @OneToMany(mappedBy = "shoppingCart")
  private List<ShoppingCartProduct> shoppingCartProducts;

  /**
   Relation with user
   */
  @ManyToOne
  @JoinColumn(name = "id_user", referencedColumnName = "id")
  private User user;

  /**
   Builder of entity
   */
  public ShoppingCart() {
  }
}
