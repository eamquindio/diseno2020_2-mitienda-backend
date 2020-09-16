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
 * Shopping Cart's class
 */
@Entity
@Table(name = "shopping_carts")
public class ShoppingCart implements Serializable {

  /**
   * Shopping Cart's - Primary key
   */
  @Id
  private Long id;

  /**
   * Store of the shopping cart - Foreign key
   */
  @ManyToOne
  @JoinColumn(name = "id_store", referencedColumnName = "id")
  private Store store;

  /**
   * Shopping Cart's Product
   */
  @OneToMany(mappedBy = "shoppingCart")
  private List<ShoppingCartProduct> product;

  /**
   * User of the shopping cart - Foreign Key
   */
  @ManyToOne
  @JoinColumn(name = "id_user", referencedColumnName = "id")
  private User user;

  /**
   * Shopping Cart's constructors
   */
  public ShoppingCart() {
  }

  public ShoppingCart(Long id, Store store, List<ShoppingCartProduct> product, User user) {
    this.id = id;
    this.store = store;
    this.product = product;
    this.user = user;
  }

  public ShoppingCart(Long id) {
    this.id = id;
  }

  /**
   * ShoppingCart constructors with id, store, user
   *
   * @param id    , id
   * @param store , store
   * @param user  , user
   */
  public ShoppingCart(Long id, Store store, User user) {
    this.id = id;
    this.store = store;
    this.user = user;
  }

  /**
   * ShoppingCart's Get Id method
   *
   * @return Id
   */
  public Long getId() {
    return id;
  }

  /**
   * ShoppingCart's Set Id method
   * @param id , id we want to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * ShoppingCart's Get Store method
   * @return Store
   */
  public Store getStore() {
    return store;
  }

  /**
   * ShoppingCart's Set Store method
   * @param store , store we want to set
   */
  public void setStore(Store store) {
    this.store = store;
  }

  /**
   * ShoppingCart's Get List of Shopping Cart Products method
   * @return List of ShoppingCartProduct
   */
  public List<ShoppingCartProduct> getProduct() {
    return product;
  }

  /**
   * ShoppingCart's Set List of Shopping Cart Products method
   * @param product , product we want to set
   */
  public void setProduct(List<ShoppingCartProduct> product) {
    this.product = product;
  }

  /**
   * ShoppingCart's Get User method
   * @return User
   */
  public User getUser() {
    return user;
  }

  /**
   * ShoppingCart's Set User method
   * @param user , user we want to set
   */
  public void setUser(User user) {
    this.user = user;
  }
}
