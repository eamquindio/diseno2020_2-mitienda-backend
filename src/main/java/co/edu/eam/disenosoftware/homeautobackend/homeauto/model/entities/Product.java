package co.edu.eam.disenosoftware.homeautobackend.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad products
 */
@Entity
@Table(name = "products")
public class Product {

  /**
   * Primary Key
   */
  @Id
  private Long id;

  /**
   * Products img
   */
  private String img;

  /**
   * Products name
   */
  private String name;

  /**
   * Constructor
   */
  public Product() {
  }
}
