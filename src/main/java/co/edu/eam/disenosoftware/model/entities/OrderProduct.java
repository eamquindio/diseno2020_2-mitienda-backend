package co.edu.eam.disenosoftware.model.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entities orderProduct
 */

@Entity
@Table(name = "order_products")
public class OrderProduct implements Serializable {

  /**
   * product order product
   */

  @ManyToOne
  @JoinColumn(name = "id_product", referencedColumnName = "id")
  private ProductStore product;

  /**
   * product order quantity
   */

  private int quantity;

  /**
   * product status on order
   */

  private String state;

  /**
   * ManyToOne orders
   */
  @ManyToOne
  @JoinColumn(name = "id_order", referencedColumnName = "id")
  private Order orders;

  /**
   * order Product builder
   */

  public OrderProduct() {
  }
}
