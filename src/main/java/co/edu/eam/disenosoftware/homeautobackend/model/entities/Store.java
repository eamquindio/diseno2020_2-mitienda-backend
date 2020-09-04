package co.edu.eam.disenosoftware.homeautobackend.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Store's class
 */
@Entity
@Table(name = "stores")
public class Store implements Serializable {

  /**
<<<<<<< HEAD:src/main/java/co/edu/eam/disenosoftware/homeautobackend/model/entities/Store.java
   * Store's - Primary key
=======
   *Store's primary key
>>>>>>> 216ac10... corrigiendo estructuracion del proyecto (carpetas y entidades):src/main/java/co/edu/eam/disenosoftware/homeauto/mode/entities/Store.java
   */
  @Id
  private Long id;

  /**
   * Store's name
   */
  private String name;

  /**
   * Store's owner
   */
  private String owner;

  /**
   * Store's address
   */
  private String address;

  /**
   * Store's image
   */
  private String image;

  /**
   * Store's delivery
   */
  private boolean delivery;

  /**
   * Store's is open
   */
  @Column(name = "is_open")
  private boolean isOpen;

  /**
   * Store's phone
   */
  private String phone;

  /**
   * Store's email
   */
  private String email;

  /**
   * Store's password
   */
  private  String password;

  /**
<<<<<<< HEAD:src/main/java/co/edu/eam/disenosoftware/homeautobackend/model/entities/Store.java
   * Store's constructor
   */
  public Store() {
  }
=======
   *Store's constructor
   */
  public Store() {
  }

>>>>>>> 216ac10... corrigiendo estructuracion del proyecto (carpetas y entidades):src/main/java/co/edu/eam/disenosoftware/homeauto/mode/entities/Store.java
}
