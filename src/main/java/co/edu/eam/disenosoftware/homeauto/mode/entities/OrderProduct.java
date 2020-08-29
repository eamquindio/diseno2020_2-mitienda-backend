package co.edu.eam.disenosoftware.homeauto.mode.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "order_products")
/**
 * Order's products class
 */
public class OrderProduct implements Serializable {

  /**
   * Order's products constructor
   */
  public OrderProduct() {
  }

  /**
   * Order of the product
   */
  @ManyToOne
  @JoinColumn(name = "order_id", referencedColumnName = "id")
  private Order order;

  /**
   * Product of the order
   */
  @ManyToOne
  @JoinColumn(name = "id_product", referencedColumnName = "id")
  private ProductStore product;

  /**
   * Quantity of the product in the order
   */
  private int quantity;

  /**
   * State of Order's products
   */
  private String state;

}
