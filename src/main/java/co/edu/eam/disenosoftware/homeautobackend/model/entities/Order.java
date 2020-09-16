package co.edu.eam.disenosoftware.homeautobackend.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *  Order's class
 */
@Entity
@Table(name = "orders")
public class Order implements Serializable {

  /**
   * Order's - Primary key
   */
  @Id
  private Long id;

  /**
   * Order's products
   */
  @OneToMany(mappedBy = "order")
  private List<OrderProduct> product;

  /**
   * Store's order - Foreign key
   */
  @ManyToOne
  @JoinColumn(name = "id_store", referencedColumnName = "id")
  private Store store;

  /**
   * User's order - Foreign key
   */
  @ManyToOne
  @JoinColumn(name = "id_user", referencedColumnName = "id")
  private User user;

  /**
   * Order's state
   */
  private String state;

  /**
   * Order's date
   */
  private Date date;

  /**
   * Order's constructor
   */
  public Order() {
  }

  /**
   * Order's constructor
   * @param id primary key
   * @param user user's order foreign key
   * @param state order's state
   */
  public Order(Long id, User user, String state) {
    this.id = id;
    this.user = user;
    this.state = state;
  }

  /**
   * Order's constructor with params
   */
  public Order(Long id, List<OrderProduct> product, Store store, User user, String state, Date date) {
    this.id = id;
    this.product = product;
    this.store = store;
    this.user = user;
    this.state = state;
    this.date = date;
  }

  /**
   * Order's Get Id method
   * @return id
   */
  public Long getId() {
    return id;
  }

  /**
   * Order's set Id method
   * @param  id address
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Order's Get products' list method
   * @return product
   */
  public List<OrderProduct> getProduct() {
    return product;
  }

  /**
   * Order's set products' list method
   * @param  product list
   */
  public void setProduct(List<OrderProduct> product) {
    this.product = product;
  }

  /**
   * Order's Get store method
   * @return store
   */
  public Store getStore() {
    return store;
  }

  /**
   * Order's set store
   * @param  store object store
   */
  public void setStore(Store store) {
    this.store = store;
  }

  /**
   * Order's Get User method
   * @return user
   */
  public User getUser() {
    return user;
  }

  /**
   * Order's set User
   * @param  user object user
   */
  public void setUser(User user) {
    this.user = user;
  }

  /**
   * Order's Get state method
   * @return state
   */
  public String getState() {
    return state;
  }

  /**
   * Order's set state
   * @param  state of order
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * Order's Get date method
   * @return date
   */
  public Date getDate() {
    return date;
  }

  /**
   * Order's set date
   * @param  date time
   */
  public void setDate(Date date) {
    this.date = date;
  }
}
