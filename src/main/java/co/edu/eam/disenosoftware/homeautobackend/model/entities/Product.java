package co.edu.eam.disenosoftware.homeautobackend.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * class
 */
@Entity
@Table(name = "products")
public class Product implements Serializable {

  /**
   * id primary key product
   */
  @Id
  private Long id;

  /**
   * image product
   */
  private String image;

  /**
   * name product
   */
  private String name;

  /**
   * builder product
   */
  public Product() {
  }
}
