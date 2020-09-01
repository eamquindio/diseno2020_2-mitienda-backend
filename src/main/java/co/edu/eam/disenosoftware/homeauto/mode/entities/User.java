package co.edu.eam.disenosoftware.homeauto.mode.entities;

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
   * User's constructor
   */
  public User() {
  }

  /**
   * User's primary key
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
   * User's E-mail
   */
  private String email;

  /**
   * User's account password
   */
  private String password;

  /**
   * User's living address
   */
  private String address;

  /**
   * User's real name
   */
  private String name;

}
