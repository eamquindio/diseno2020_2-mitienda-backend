package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Class Product
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

  /**
   * Product Image
   */
  private String image;

  /**
   * Product Name
   */
  private String name;

  /**
   * ID Product
   */
  @Id
  private Long id;

  /**
   * Product Constructor
   */
  public Product() {
  }
}
