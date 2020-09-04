package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entity categories
 */
@Entity
@Table(name = "categories")
public class Category implements Serializable {

  /**
   Prime key Entity categories
   */
  @Id
  private String id;

  /**
   Category icon
   */
  private String icon;
  /**
   Categories' stored
   */
  private String stored;
  /**
   Category's name
   */
  private String name;

  /**
   Builder of category
   */
  public Category() {
  }
}
