package co.edu.eam.disenosoftware.homeautobackend.model.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * Shopping cart product: class
 */
@Entity
@Table(name = "tb_shopping_cart_products")
public class ShoppingCartProduct implements Serializable {

  /**
   * Shopping cart's products primary key
   */
  @Id
  private Long id;

  @ManyToOne
  @JoinColumn(name = "shopping_cart_id", referencedColumnName = "id")
  private ShoppingCart shoppingCart;
  /**
   * Shopping cart product: product from store
   */
  @ManyToOne
  @JoinColumn(name = "product_store_id", referencedColumnName = "id")
  private ProductStore product;

  /**
   * Shopping cart product: quantity
   */

  private int quantity;

  /**
   * Shopping cart product: constructor
   */
  public ShoppingCartProduct() {

  }

  /**
   * shopping cart product get id
   *
   * @return , id
   */
  public Long getId() {
    return id;
  }

  /**
   * shopping cart product set id
   *
   * @param id , id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * shopping cart product get product
   *
   * @return , product
   */
  public ProductStore getProduct() {
    return product;
  }

  /**
   * shopping cart product set product
   *
   * @param product , product
   */
  public void setProduct(ProductStore product) {
    this.product = product;
  }

  /**
   * shopping cart product get quantity
   *
   * @return , quantity
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * shopping cart product set quantity
   *
   * @param quantity , quantity
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /**
   * shopping cart product to string
   *
   * @return , to string
   */
  @Override
  public String toString() {
    return "ShoppingCartProduct{"
            + "id=" + id
            + ", product=" + product
            + ", quantity=" + quantity
            + '}';
  }
}
