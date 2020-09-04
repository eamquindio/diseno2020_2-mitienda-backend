package co.edu.eam.disenosoftware.homeautobackend.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * User's class
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

  /**
<<<<<<< HEAD:src/main/java/co/edu/eam/disenosoftware/homeautobackend/model/entities/User.java
   * User's - Primary key
=======
   * User's primary key
>>>>>>> 216ac10... corrigiendo estructuracion del proyecto (carpetas y entidades):src/main/java/co/edu/eam/disenosoftware/homeauto/mode/entities/User.java
   */
  @Id
  private Long id;

  /**
   * User's username
   */
  private String username;

  /**
   * User's phone
   */
  private String phone;

  /**
   * User's email
   */
  private String email;

  /**
   * User's password
   */
  private String password;

  /**
   * User's name
   */
  private String name;

  /**
   * User's constructor
   */
<<<<<<< HEAD:src/main/java/co/edu/eam/disenosoftware/homeautobackend/model/entities/User.java
  public User() {
  }
=======
  private String name;

  /**
   * User's constructor
   */
  public User() {
  }

>>>>>>> 216ac10... corrigiendo estructuracion del proyecto (carpetas y entidades):src/main/java/co/edu/eam/disenosoftware/homeauto/mode/entities/User.java
}
