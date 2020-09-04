package co.edu.eam.disenosoftware.homeautobackend.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * class order product
 */
@Entity
@Table(name = "order_products")
public class OrderProduct implements Serializable {

  /**
   * id class order
   */
  @Id
  private Long id;

  /**
   * mapped order product
   */
  @ManyToOne
  @JoinColumn(name = "id_product_store", referencedColumnName = "id")
  private ProductStore product;

  /**
   * quantity order product
   */
  private int quantity;

  /**
   * state order product
   */
  private String state;

  /**
   * builder order product
   */
  public OrderProduct() {
  }
}
