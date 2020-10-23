package co.edu.eam.disenosoftware.mitienda.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * Order of the products - Foreign Key
   */
  @ManyToOne
  @JoinColumn(name = "id_order", referencedColumnName = "id")
  @JsonBackReference
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
   * OrdersProduct constructor default
   * @param l
   * @param i
   * @param removed
   * @param l1
   * @param l2
   */
  public OrderProduct(long l, int i, String removed, long l1, long l2) {
  }

  /**
   * OrdersProduct constructor default
   */
  public OrderProduct() {
  }

  /**
   * Constructor
   * @param order
   * @param productStore
   * @param quantity
   * @param state
   */
  public OrderProduct(Order order, ProductStore productStore, int quantity, String state) {
    this.order = order;
    this.productStore = productStore;
    this.quantity = quantity;
    this.state = state;
  }

  /**
   * Product's Get Id method
   *
   * @return Id
   */
  public Long getId() {
    return id;
  }

  /**
   * Product's Set Id method
   *
   * @param id , id we want to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Product's Get Order method
   *
   * @return order
   */
  public Order getOrder() {
    return order;
  }

  /**
   * Product's Set order method
   *
   * @param order , order we want to set
   */
  public void setOrder(Order order) {
    this.order = order;
  }

  /**
   * Product's Get productStore method
   *
   * @return productStore
   */
  public ProductStore getProductStore() {
    return productStore;
  }

  /**
   * Product's Set productStore method
   *
   * @param productStore , productStore we want to set
   */
  public void setProductStore(ProductStore productStore) {
    this.productStore = productStore;
  }

  /**
   * Product's Get quantity method
   *
   * @return quantity
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * Product's Set quantity method
   *
   * @param quantity , quantity we want to set
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /**
   * Product's Get state method
   *
   * @return state
   */
  public String getState() {
    return state;
  }

  /**
   * Product's Set state method
   *
   * @param state , state we want to set
   */
  public void setState(String state) {
    this.state = state;
  }
}
