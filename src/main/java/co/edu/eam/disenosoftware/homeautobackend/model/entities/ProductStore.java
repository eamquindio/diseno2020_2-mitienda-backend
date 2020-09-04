package co.edu.eam.disenosoftware.homeautobackend.model.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * Product store's: class
 */
@Entity
@Table(name = "tb_product_stores")
public class ProductStore implements Serializable {

  /**
   * Product store's id
   */
  @Id
  private Long id;

  /**
   * Product store's: product
   */
  @ManyToOne
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private Product product;

  /**
   * Product store's stock
   */

  private int stock;

  /**
   * Product store's price
   */

  private double price;
  /**
   * Product store's: category
   */
  @ManyToOne
  @JoinColumn(name = "category_id", referencedColumnName = "id")
  private Category category;

  /**
   * Product store's: store
   */
  @ManyToOne
  @JoinColumn(name = "store_id", referencedColumnName = "id")
  private Store store;


  /**
   * Product store's constructor
   */

  public ProductStore() {

  }

  /**
   * product store get id
   *
   * @return , id
   */
  public Long getId() {
    return id;
  }

  /**
   * product store set id
   *
   * @param id , id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * product store get product
   *
   * @return , product
   */
  public Product getProduct() {
    return product;
  }

  /**
   * product store set product
   *
   * @param product , product
   */
  public void setProduct(Product product) {
    this.product = product;
  }

  /**
   * product store get stock
   *
   * @return , stock
   */
  public int getStock() {
    return stock;
  }

  /**
   * product store set stock
   *
   * @param stock , stock
   */
  public void setStock(int stock) {
    this.stock = stock;
  }

  /**
   * product store
   *
   * @return get price
   */
  public double getPrice() {
    return price;
  }

  /**
   * product store set price
   *
   * @param price , price
   */
  public void setPrice(double price) {
    this.price = price;
  }

  /**
   * product store get category
   *
   * @return , category
   */
  public Category getCategory() {
    return category;
  }

  /**
   * product store set category
   *
   * @param category , category
   */
  public void setCategory(Category category) {
    this.category = category;
  }

  /**
   * product store get store
   *
   * @return , store
   */
  public Store getStore() {
    return store;
  }

  /**
   * product store set store
   *
   * @param store , store
   */
  public void setStore(Store store) {
    this.store = store;
  }

  /**
   * product store to string
   *
   * @return , to string
   */
  @Override
  public String toString() {
    return "ProductStore{"
            + "id=" + id
            + ", product=" + product
            + ", stock=" + stock
            + ", price=" + price
            + ", category=" + category
            + ", store=" + store
            + '}';
  }
}
