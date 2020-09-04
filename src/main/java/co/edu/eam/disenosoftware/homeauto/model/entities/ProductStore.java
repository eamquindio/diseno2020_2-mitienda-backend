package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * class product store
 */
@Entity
@Table(name = "product_store")
public class ProductStore implements Serializable {

  /**
   * id product store
   */
  @Id
  private Long id;

  /**
   * mapped product
   */
  @OneToMany
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
  @OneToMany
  @JoinColumn(name = "id_category", referencedColumnName = "id")
  private Category category;

  /**
   * mapped store
   */
  @OneToMany
  @JoinColumn(name = "id_store", referencedColumnName = "id")
  private Store store;

  /**
   * builder product store
   */
  public ProductStore() {
  }
}
