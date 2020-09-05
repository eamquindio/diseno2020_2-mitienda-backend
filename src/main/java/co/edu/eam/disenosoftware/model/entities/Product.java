package co.edu.eam.disenosoftware.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Entities product
 */

@Entity
@Table(name = "products")
public class Product implements Serializable {

  /**
   * Id product primary key
   */
  @Id
  private Long id;

  /**
   * product image
   */

  private String image;

  /**
   * product name
   */

  private String name;

  private List<ProductStore> productStores;

  /**
   * product builder
   */

  public Product() {
  }
}
