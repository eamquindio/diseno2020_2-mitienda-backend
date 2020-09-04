package co.edu.eam.disenosoftware.homeautobackend.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Product's class
 */
@Entity
@Table(name = "products")
public class Product implements Serializable {

  /**
<<<<<<< HEAD:src/main/java/co/edu/eam/disenosoftware/homeautobackend/model/entities/Product.java
   * Product's - Primary key
=======
   * Product's Primary key
>>>>>>> 216ac10... corrigiendo estructuracion del proyecto (carpetas y entidades):src/main/java/co/edu/eam/disenosoftware/homeauto/mode/entities/Product.java
   */
  @Id
  private Long id;

  /**
   * Product's image
   */
  private String image;

  /**
   * Product's name
   */
  private String name;

  /**
   * Product's constructor
   */
  public Product() {
  }
<<<<<<< HEAD:src/main/java/co/edu/eam/disenosoftware/homeautobackend/model/entities/Product.java
=======

>>>>>>> 216ac10... corrigiendo estructuracion del proyecto (carpetas y entidades):src/main/java/co/edu/eam/disenosoftware/homeauto/mode/entities/Product.java
}
