package co.edu.eam.disenosoftware.homeautobackend.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * class product store
 */
@Entity
@Table(name = "products_store")
public class ProductStore implements Serializable {

  /**
   * id product store
   */
  @Id
  private Long id;

  /**
   * mapped product
   */
  @ManyToOne
  @JoinColumn(name = "id_product", referencedColumnName = "id")
  private Product product;

  /**
   * stock product store
   */
  private int stock;

  /**
   * price product store
   */
  private double price;

  /**
   * mapped category
   */
  @ManyToOne
  @JoinColumn(name = "id_category", referencedColumnName = "id")
  private Category category;

  /**
   * mapped store
   */
  @ManyToOne
  @JoinColumn(name = "id_store", referencedColumnName = "id")
  private Store store;

  /**
   * builder product store
   */
  public ProductStore() {
  }
}
