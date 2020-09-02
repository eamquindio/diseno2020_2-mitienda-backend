package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Order for product's: class
 */
@Entity
@Table(name = "tb_order_product")
public class OrderProduct implements Serializable {
  /**
   * Order for product's: product
   */
  @ManyToOne
  @JoinColumn(name = "id_product_store", referencedColumnName = "id")
  private ProductStore product;

  /**
   * Order for product's: quantity
   */
  @Column(name = "order_product_quantity")
  private int quantity;

  /**
   * Order for product's: state
   */
  @Column(name = "order_product_state")
  private String state;


  /**
   * Order for product's: constructor
   */
  public OrderProduct() {

  }

}
