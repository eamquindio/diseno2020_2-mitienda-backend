package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Class Product
 */
@Entity
@Table(name = "order_product")
public class OrderProduct implements Serializable {

  /**
   * ID order Product
   */
  @ManyToOne
  @JoinColumn(name = "id_order_product", referencedColumnName = "id")
  private ProductStore product;

  /**
   * Quantity Order Product
   */
  private int quantity;

  /**
   * State order Product
   */
  private String state;

  /**
   * Constructor Order Productor
   */

  public OrderProduct() {
  }
}
