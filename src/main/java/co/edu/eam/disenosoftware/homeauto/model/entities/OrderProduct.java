package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Class Order Product
 */
@Entity
@Table(name = "orders_product")
public class OrderProduct implements Serializable {

  /**
   * Product Store Order
   */
  @ManyToOne
  @JoinColumn(name = "id_product_store", referencedColumnName = "id")
  private ProductStore product;

  /**
   * Quantity Order Product
   */
  private int quantity;

  /**
   * State Order Product
   */
  private String state;

  /**
   * Constructor Order Product
   */
  public OrderProduct() {
  }
}
