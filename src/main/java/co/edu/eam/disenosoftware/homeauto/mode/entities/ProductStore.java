package co.edu.eam.disenosoftware.homeauto.mode.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Store's product class
 */
@Entity
@Table(name = "products_store")
public class ProductStore implements Serializable {

  /**
   * Store's product constructor
   */
  public ProductStore() {
  }

  /**
   * Store's product Primary key
   */
  @Id
  private Long id;

  /**
   * Product of the store
   */
  @ManyToOne
  @JoinColumn(name = "id_product", referencedColumnName = "id")
  private Product product;

  /**
   * Store's stock products quantity
   */
  private int stock;

  /**
   * product's price in the store
   */
  private double price;

  /**
   * The store's product category
   */
  @ManyToOne
  @JoinColumn(name = "id_category", referencedColumnName = "id")
  private Category category;

  /**
   * Store of the product
   */
  @ManyToOne
  @JoinColumn(name = "id_store", referencedColumnName = "id")
  private Store store;

}
