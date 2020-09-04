package co.edu.eam.disenosoftware.homeautobackend.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * class order
 */
@Entity
@Table(name = "orders")
public class Order implements Serializable {

  /**
   * id class order
   */
  @Id
  private Long id;

  /**
   * mapped list product
   */
  @OneToMany(mappedBy = "product")
  private List<OrderProduct> product;

  /**
   * store order
   */
  private Store store;

  /**
   * mapped user
   */
  @ManyToOne
  @JoinColumn(name = "id_user", referencedColumnName = "id")
  private User user;

  /**
   * state order
   */
  private String state;

  /**
   * date order
   */
  private Date date;

  /**
   * builder order
   */
  public Order() {
  }
}
