package co.edu.eam.disenosoftware.homeautobackend.homeauto.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * Entidad orders
 */
@Entity
@Table(name = "orders")
public class Order {

  /**
   * Primary Key
   */
  @Id
  private Long id;

  /**
   * List of OrderProducts
   */
  @Column(name = "order_products")
  private List<OrderProduct> orderProduct;

  /**
   * Orders store
   */
  @ManyToOne
  @JoinColumn(name = "store_id", referencedColumnName = "id")
  private Store store;

  /**
   * Orders user
   */
  @ManyToOne
  @JoinColumn(name = "user_Name", referencedColumnName = "id")
  private User userName;

  /**
   * Orders state
   */
  private String state;

  /**
   * Orders date
   */
  private Date date;

  /**
   * Constructor
   */
  public Order() {
  }
}
