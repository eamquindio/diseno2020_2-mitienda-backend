package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * class order product
 */
@Entity
@Table(name = "order_product")
public class OrderProduct implements Serializable {

  /**
   * mapped order product
   */
  @OneToMany
  @JoinColumn(name = "id_order_product", referencedColumnName = "id")
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
