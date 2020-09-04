package co.edu.eam.disenosoftware.homeautobackend.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Category class
 */
@Entity
@Table(name = "categories")
public class Category implements Serializable {

  /**
   * Category - Primary key
   */
  @Id
  private Long id;

  /**
   * Category icon
   */
  private String icon;

  /**
   * Category name
   */
  private String name;

  /**
   * Store categories - Foreign key
   */
  @ManyToOne
  @JoinColumn(name = "id_store", referencedColumnName = "id")
  private Store store;

  /**
   * Category constructor
   */
  public Category() {
  }
}
