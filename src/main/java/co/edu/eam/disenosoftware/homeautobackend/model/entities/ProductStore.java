package co.edu.eam.disenosoftware.homeautobackend.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Product's store class
 */
@Entity
@Table(name = "products_store")
public class ProductStore implements Serializable {

  /**
   * Product's store - Primary key
   */
  @Id
  private Long id;

  /**
   * Product of the store's - Foreign key
   */
  @ManyToOne
  @JoinColumn(name = "id_product", referencedColumnName = "id")
  private Product product;

  /**
   * Product's store stock
   */
  private int stock;

  /**
   * Product's store price
   */
  private double price;

  /**
   * Category of the store product's - Foreign key
   */
  @ManyToOne
  @JoinColumn(name = "id_category", referencedColumnName = "id")
  private Category category;

  /**
   * Store of the product - Foreign key
   */
  @ManyToOne
  @JoinColumn(name = "id_store", referencedColumnName = "id")
  private Store store;

  /**
   * Product's store constructors
   */
  public ProductStore() {
  }

  public ProductStore(Long id, Product product, int stock, double price, Category category, Store store) {
    this.id = id;
    this.product = product;
    this.stock = stock;
    this.price = price;
    this.category = category;
    this.store = store;
  }

  public ProductStore(Long id) {
    this.id = id;
  }

  /**
   * ProductStores's Get Id method
   * @return Id
   */
  public Long getId() {
    return id;
  }

  /**
   * ProductStores's Set Id method
   * @param id , id we want to set
   */
  public void setId(Long id) {
    this.id = id;
  }
}
