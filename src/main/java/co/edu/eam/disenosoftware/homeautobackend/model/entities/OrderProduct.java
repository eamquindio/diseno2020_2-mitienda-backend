package co.edu.eam.disenosoftware.homeautobackend.model.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Order for product's: class
 */
@Entity
@Table(name = "tb_order_products")
public class OrderProduct implements Serializable {

  /**
   * Order's product primary key
   */
  @Id
  private Long id;
  /**
   * Order for product's: product
   */
  @ManyToOne
  @JoinColumn(name = "id_product_store", referencedColumnName = "id")
  private ProductStore product;

  /**
   * Order for product's: quantity
   */

  private int quantity;

  /**
   * Order for product's: state
   */

  private String state;


  /**
   * Order for product's: constructor
   */
  public OrderProduct() {

  }


  /**
   * order product get id
   *
   * @return , id
   */
  public Long getId() {
    return id;
  }

  /**
   * order product set id
   *
   * @param id , id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * order product get product
   *
   * @return , product
   */
  public ProductStore getProduct() {
    return product;
  }

  /**
   * order product set product
   *
   * @param product , product
   */
  public void setProduct(ProductStore product) {
    this.product = product;
  }

  /**
   * order product get quantity
   *
   * @return , quantity
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * oder product set quantity
   *
   * @param quantity , quantity
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /**
   * order product get state
   *
   * @return , state
   */
  public String getState() {
    return state;
  }

  /**
   * order product set state
   *
   * @param state , state
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * order product to string
   *
   * @return , to string
   */
  @Override
  public String toString() {
    return "OrderProduct{"
            + "id=" + id
            + ", product=" + product
            + ", quantity=" + quantity
            + ", state='" + state + '\''
            + '}';
  }
}
