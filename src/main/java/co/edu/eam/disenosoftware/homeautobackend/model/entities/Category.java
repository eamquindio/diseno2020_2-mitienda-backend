package co.edu.eam.disenosoftware.homeautobackend.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * class category
 */
@Entity
@Table(name = "categories")
public class Category implements Serializable {

  /**
   * Id category
   */

  @Id
  private Long id;

  /**
   * icon category
   */
  private String icon;

  /**
   * name category
   */
  private String name;

  /**
   * builder category
   */
  public Category() {
  }
}
