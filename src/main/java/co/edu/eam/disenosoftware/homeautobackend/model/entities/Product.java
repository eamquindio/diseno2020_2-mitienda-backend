package co.edu.eam.disenosoftware.homeautobackend.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Product's class
 */
@Entity
@Table(name = "products")
public class Product implements Serializable {

  /**
   * Product's - Primary key
   */
  @Id
  private Long id;

  /**
   * Product's image
   */
  private String image;

  /**
   * Product's name
   */
  private String name;

  /**
   * Product's constructor
   */
  public Product() {
  }
}

