package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 Entity table order product
 */
@Entity
/**
 Table's name
 */
@Table(name = "order_poducts")
public class OrderProduct implements Serializable {

  /**
   Prime key of order product
   */
  @Id
  private Long code;

  /**
   Relation with product store
   */
  @ManyToOne
  @JoinColumn(name = "product_store_code", referencedColumnName = "code")
  private ProductStore product;

  /**
   Quantity of Order product
   */
  private int quantity;

  /**
   State of the order product
   */
  private String state;

  /**
   Relation with order
   */
  @ManyToOne
  @JoinColumn(name = "order_id", referencedColumnName = "id")
  private Order order;

  /**
   builder of order product
   */
  public OrderProduct() {
  }
}
