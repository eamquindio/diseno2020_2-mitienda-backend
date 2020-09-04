package co.edu.eam.disenosoftware.homeautobackend.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Class Product Store
 */
@Entity
@Table(name = "product_stores")
public class ProductStore implements Serializable {

  /**
   * Id product Store
   */
  @ManyToOne
  @JoinColumn(name = "id_product", referencedColumnName = "id")
  private Product product;

  /**
   * Stock product Store
   */
  private int stock;

  /**
   * Product Store Price
   */
  private double price;

  /**
   * Id category
   */
  @ManyToOne
  @JoinColumn(name = "id_category", referencedColumnName = "id")
  private Category category;

  /**
   * ID store
   */
  @ManyToOne
  @JoinColumn(name = "id_store", referencedColumnName = "id")
  private Store store;

  /**
   * ID Product Store
   */
  @Id
  private Long id;

  /**
   * Constructor Product Store
   */
  public ProductStore() {
  }
}
