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
 * Order's class
 */
@Entity
@Table(name = "tb_orders")
public class Order implements Serializable {
  /**
   * Order's id
   */
  @Id
  private Long id;
  /**
   * Order: list of product's
   */
  @OneToMany(mappedBy = "order")
  private List<OrderProduct> product;

  /**
   * Order: list of store's
   */
  @ManyToOne
  @JoinColumn(name = "store_id", referencedColumnName = "id")
  private Store store;

  /**
   * Order: list of user's
   */
  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
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
   * order get id
   *
   * @return , id
   */
  public Long getId() {
    return id;
  }

  /**
   * order set id
   *
   * @param id , id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * order get list of products
   *
   * @return , list of products
   */
  public List<OrderProduct> getProduct() {
    return product;
  }

  /**
   * order set list of products
   *
   * @param product , list of products
   */
  public void setProduct(List<OrderProduct> product) {
    this.product = product;
  }

  /**
   * order get list of stores
   *
   * @return , list of stores
   */
  public Store getStore() {
    return store;
  }

  /**
   * order set list of stores
   *
   * @param store , list of stores
   */
  public void setStore(Store store) {
    this.store = store;
  }

  /**
   * order get user
   *
   * @return , user
   */
  public User getUser() {
    return user;
  }

  /**
   * order set user
   *
   * @param user , user
   */
  public void setUser(User user) {
    this.user = user;
  }

  /**
   * order get state
   *
   * @return , state
   */
  public String getState() {
    return state;
  }

  /**
   * order set state
   *
   * @param state , state
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * order get date
   *
   * @return , date
   */
  public Date getDate() {
    return date;
  }

  /**
   * order set date
   *
   * @param date , date
   */
  public void setDate(Date date) {
    this.date = date;
  }

  /**
   * order to string
   *
   * @return , to string
   */
  @Override
  public String toString() {
    return "Order{"
            + "id=" + id
            + ", store=" + store
            + ", user=" + user
            + ", state='" + state + '\''
            + ", date=" + date
            + '}';
  }
}
