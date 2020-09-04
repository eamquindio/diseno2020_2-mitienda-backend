package co.edu.eam.disenosoftware.homeautobackend.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad categorys
 */
@Entity
@Table(name = "categorys")
public class Category {

  /**
   * Primary Key
   */
  @Id
  private Long id;

  /**
   * Category icon
   */
  private String icon;

  /**
   * Category storeld
   */
  private String storeld;

  /**
   * Category name
   */
  private String name;

  /**
   * Constructor
   */
  public Category() {
  }
}
