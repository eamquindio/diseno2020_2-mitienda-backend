package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * entities product
 */

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

  /**
   * id product primary key
   */

  @Id
  @Column(name = "product_id")
  private Long id;

  /**
   * product image
   */

  @Column(name = "product_image")
  private String image;

  /**
   * product name
   */

  @Column(name = "product_name")
  private String name;

  /**
   * product builder
   */

  public Product() {
  }
}
