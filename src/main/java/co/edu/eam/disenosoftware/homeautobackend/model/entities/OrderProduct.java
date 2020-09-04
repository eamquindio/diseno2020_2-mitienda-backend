package co.edu.eam.disenosoftware.homeautobackend.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Order's products class
 */
@Entity
@Table(name = "order_products")
public class OrderProduct implements Serializable {

  /**
   * Order's product primary key
   */
  @Id
  private Long id;

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

  /**
   * Order's products constructor
   */
  public OrderProduct() {
  }

}
