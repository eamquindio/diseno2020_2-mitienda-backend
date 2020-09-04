package co.edu.eam.disenosoftware.homeautobackend.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * class user
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

  /**
   * id user
   */
  @Id
  private Long id;

  /**
   * user name
   */
  private String userName;

  /**
   * phone user
   */
  private String phone;

  /**
   * email user
   */
  private String email;

  /**
   * password user
   */
  private String password;

  /**
   * address user
   */
  private String address;

  /**
   * name user
   */
  private String name;

  /**
   * builder user
   */
  public User() {
  }
}
