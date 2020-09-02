package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * entities orderProduct
 */

@Entity
@Table(name = "tb_order_product")
public class OrderProduct implements Serializable {

  /**
   * product order product
   */

  @Column(name = "orderProduct_product")
  private ProductStore product;

  /**
   * product order quantity
   */

  @Column(name = "orderProduct_quantity")
  private int quantity;

  /**
   * product status on order
   */

  @Column(name = "orderProduct_state")
  private String state;

  /**
   * order Product builder
   */

  public OrderProduct() {
  }
}
