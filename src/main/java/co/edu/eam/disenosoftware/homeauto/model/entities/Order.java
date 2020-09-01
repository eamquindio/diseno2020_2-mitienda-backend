package co.edu.eam.disenosoftware.homeauto.model.entities;

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
   * Order's primary key
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

}
