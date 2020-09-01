package co.edu.eam.disenosoftware.homeauto.mode.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Category's class
 */
@Entity
@Table(name = "categories")
public class Category implements Serializable {

  /**
   * Category's constructor
   */
  public Category() {
  }

  /**
   * Category's primary key
   */
  @Id
  private Long id;

  /**
   * Category's icon
   */
  private String icon;

  /**
   * Store to which category belongs
   */
  @ManyToOne
  @JoinColumn(name = "id_store", referencedColumnName = "id")
  private Store store;

  /**
   * Category's name
   */
  private String name;

}
