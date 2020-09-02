package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Product's class
 */
@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
  /**
   * Product's Id
   */
  @Id
  @Column(name = "product_id")
  private String id;
  /**
   * Product's image
   */
  @Column(name = "product_image")
  private String image;
  /**
   * Product's name
   */
  @Column(name = "product_name")
  private String name;

  /**
   * Product's constructor
   */
  public Product() {

  }
}
