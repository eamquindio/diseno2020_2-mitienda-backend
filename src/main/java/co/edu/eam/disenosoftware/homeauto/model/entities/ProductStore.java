package co.edu.eam.disenosoftware.homeauto.model.entities;

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
   * Product's store primary key
   */
  @Id
  private String id;

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
   * Product's store constructor
   */
  public ProductStore() {
  }

}
