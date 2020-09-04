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
<<<<<<< HEAD:src/main/java/co/edu/eam/disenosoftware/homeautobackend/model/entities/Category.java
   * Category - Primary key
=======
   * Category's primary key
>>>>>>> 216ac10... corrigiendo estructuracion del proyecto (carpetas y entidades):src/main/java/co/edu/eam/disenosoftware/homeauto/mode/entities/Category.java
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
<<<<<<< HEAD:src/main/java/co/edu/eam/disenosoftware/homeautobackend/model/entities/Category.java
  public Category() {
  }
=======
  private String name;

  /**
   * Category's constructor
   */
  public Category() {
  }

>>>>>>> 216ac10... corrigiendo estructuracion del proyecto (carpetas y entidades):src/main/java/co/edu/eam/disenosoftware/homeauto/mode/entities/Category.java
}
