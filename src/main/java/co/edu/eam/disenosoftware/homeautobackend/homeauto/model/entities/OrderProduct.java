package co.edu.eam.disenosoftware.homeautobackend.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order_products")
public class OrderProduct {

  /**
   * OrderProducts products
   */
  @ManyToOne
  @JoinColumn(name = "product_store", referencedColumnName = "id")
  private ProductStore productStore;

  /**
   * OrderProdcuts quantity
   */
  private int quantity;

  /**
   * OrderProducts state
   */
  private String state;

  /**
   * Constructor
   */
  public OrderProduct() {
  }
}
