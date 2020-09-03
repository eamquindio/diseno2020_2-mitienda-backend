package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Class Product Store
 */
@Entity
@Table(name = "product_store")
public class ProductStore implements Serializable {

  /**
   * Product Store
   */
  @ManyToOne
  @JoinColumn(name = "id_product", referencedColumnName = "id")
  private Product product;

  /**
   * Stock Product Store
   */
  private int stock;

  /**
   * Price Product Store
   */
  private double price;

  /**
   * Category Product Store
   */
  @ManyToOne
  @JoinColumn(name = "id_category", referencedColumnName = "id")
  private Category category;

  /**
   * Store Product
   */
  @ManyToOne
  @JoinColumn(name = "id_store", referencedColumnName = "id")
  private Store store;

  /**
   * Id Product Store
   */
  @Id
  private String id;

  /**
   * Constructor Product Store
   */
  public ProductStore() {
  }
}
