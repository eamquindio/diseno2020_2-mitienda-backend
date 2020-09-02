package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * entities order
 */

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

  /**
   * id order primary key
   */

  @Id
  @Column(name = "order_id")
  private Long id;

  /**
   * order product
   */

  @Column(name = "order_product")
  private List<OrderProduct> product;

  /**
   * store order
   */

  @Column(name = "order_store")
  private Store store;

  /**
   * user order
   */

  @Column(name = "order_user")
  private User user;

  /**
   * state order
   */

  @Column(name = "order_state")
  private String state;

  /**
   * date order
   */

  @Column(name = "order_date")
  private Date date;

  /**
   * constructor order
   */

  public Order() {
  }
}
