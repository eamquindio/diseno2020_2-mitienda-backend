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
   * Username
   */
  private String userName;

  /**
   * Phone User
   */
  private String phone;

  /**
   * Email User
   */
  private String email;

  /**
   * Password User
   */
  private String password;

  /**
   * Address User
   */
  private String address;

  /**
   * Name User
   */
  private String name;

  /**
   * Id User
   */
  @Id
  private String id;

  /**
   * Constructor User
   */
  public User() {
  }
}
