package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * class category
 */
@Entity
@Table(name = "category")
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
   * storeld category
   */
  private String storeld;

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
