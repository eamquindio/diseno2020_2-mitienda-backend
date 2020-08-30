package co.edu.eam.disenosoftware.homeauto.model.entities;

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
   * Product's primary key
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

  /**
   * Product's constructor
   */
  public Product() {
  }

}
