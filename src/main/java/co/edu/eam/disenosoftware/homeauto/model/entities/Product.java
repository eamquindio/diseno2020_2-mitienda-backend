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
   * Id Product
   */
  @Id
  private String id;

  /**
   * Image Product
   */
  private String image;

  /**
   * Name Product
   */
  private String name;

  /**
   * Constructor Product
   */
  public Product() {
  }
}
