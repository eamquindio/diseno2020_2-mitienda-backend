package co.edu.eam.disenosoftware.homeauto.model.entities;

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
   * Order's products - Primary key
   */
  @Id
  private Long id;

  /**
   * Order of the products - Foreign Key
   */
  @ManyToOne
  @JoinColumn(name = "id_order", referencedColumnName = "id")
  private Order order;

  /**
   * Store's product of the order - Foreign Key
   */
  @ManyToOne
  @JoinColumn(name = "id_product", referencedColumnName = "id")
  private ProductStore productStore;

  /**
   * Order's products quantity
   */
  private int quantity;

  /**
   * Order's products state
   */
  private String state;

  /**
   * Order's products constructor
   */
  public OrderProduct() {
  }

}
