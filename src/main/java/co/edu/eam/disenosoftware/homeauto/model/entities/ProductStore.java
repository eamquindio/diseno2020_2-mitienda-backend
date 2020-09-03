package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Class Product Store
 */
@Entity
@Table(name = "product_store")
public class ProductStore implements Serializable {

  /**
   * Id product Store
   */
  @OneToMany
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
  @OneToOne
  @JoinColumn(name = "id_category", referencedColumnName = "id")
  private Category category;

  /**
   * ID store
   */
  @OneToMany
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
