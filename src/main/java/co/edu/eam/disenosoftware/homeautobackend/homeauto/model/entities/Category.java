package co.edu.eam.disenosoftware.homeautobackend.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
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
