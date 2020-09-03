package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Class User
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

  /**
   * User username
   */
  private String userName;

  /**
   * Phone user
   */
  private String phone;

  /**
   * user email
   */
  private String email;

  /**
   * user password
   */
  private String password;

  /**
   * user address
   */
  private String address;

  /**
   * user name
   */
  private String name;

  /**
   * user id
   */
  @Id
  private Long id;

  /**
   * user contructor
   */
  public User() {
  }
}
