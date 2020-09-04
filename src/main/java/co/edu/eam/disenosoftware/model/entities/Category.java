package co.edu.eam.disenosoftware.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entities category
 */

@Entity
@Table(name = "categories")
public class Category implements Serializable {

  /**
   * Id category primary key
   */

  @Id
  private Long id;

  /**
   * icon category
   */

  private String icon;

  /**
   * store category
   */

  private Store store;

  /**
   * name category
   */

  private String name;

  /**
   * constructor category
   */

  public Category() {
  }

}
