package co.edu.eam.disenosoftware.homeauto.mode.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "products")
/**
 * Product's class
 */
public class Product implements Serializable {

  /**
   * Product's constructor
   */
  public Product() {
  }

  /**
   * Product's Primary key
   */
  @Id
  private String id;

  /**
   * Product's image
   */
  private String image;

  /**
   * Product's name
   */
  private String name;

}
