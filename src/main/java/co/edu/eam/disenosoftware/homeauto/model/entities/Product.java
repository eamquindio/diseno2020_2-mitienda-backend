package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * class
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

  /**
   * id product
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
