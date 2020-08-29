package co.edu.eam.disenosoftware.homeauto.mode.entities;

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
@Table(name = "orders")
public class Order implements Serializable {

  /**
   * Order's constructor
   */
  public Order() {
  }

  /**
   * Order's primary key
   */
  @Id
  private String id;

  /**
   * List of products from the order
   */
  @OneToMany(mappedBy = "order")
  private List<OrderProduct> product;

  /**
   * Order's store
   */
  @ManyToOne
  @JoinColumn(name = "id_store", referencedColumnName = "id")
  private Store store;

  /**
   * Order's user
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

}
