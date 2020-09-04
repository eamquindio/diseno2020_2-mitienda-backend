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
 * Shopping cart: class
 */
@Entity
@Table(name = "tb_shopping_carts")
public class ShoppingCart implements Serializable {

  /**
   * Shopping cart id
   */
  @Id
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
  @OneToMany(mappedBy = "shoppingCart")
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

  /**
   * shopping cart get id
   *
   * @return , id
   */
  public Long getId() {
    return id;
  }

  /**
   * shopping cart set id
   *
   * @param id , id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * shopping cart get store
   *
   * @return , store
   */
  public Store getStore() {
    return store;
  }

  /**
   * shopping cart set store
   *
   * @param store , store
   */
  public void setStore(Store store) {
    this.store = store;
  }

  /**
   * shopping cart get list of product
   *
   * @return , list of products
   */
  public List<ShoppingCartProduct> getProduct() {
    return product;
  }

  /**
   * shopping cart set list of product
   *
   * @param product , list of products
   */
  public void setProduct(List<ShoppingCartProduct> product) {
    this.product = product;
  }

  /**
   * shopping cart get users
   *
   * @return , user
   */
  public User getUser() {
    return user;
  }

  /**
   * shopping cart set user
   *
   * @param user , user
   */
  public void setUser(User user) {
    this.user = user;
  }

  /**
   * shopping cart to string
   *
   * @return , to string
   */
  @Override
  public String toString() {
    return "ShoppingCart{"
            + "id=" + id
            + ", store=" + store
            + ", user=" + user
            + '}';
  }
}
