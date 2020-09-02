package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * User's class
 */
@Entity
@Table(name = "tb_user")
public class User implements Serializable {

  /**
   * User's identification
   */
  @Id
  @Column(name = "user_id")
  private String id;

  /**
   * User's name
   */
  @Column(name = "user_name")
  private String name;

  /**
   * User's address
   */
  @Column(name = "user_address")
  private String address;

  /**
   * User's password
   */
  @Column(name = "user_password")
  private String password;

  /**
   * User's email
   */
  @Column(name = "user_email")
  private String email;

  /**
   * User's phone
   */
  @Column(name = "user_phone")
  private String phone;

  /**
   * User's username
   */
  @Column(name = "user_username")
  private String username;

  /**
   * User's constructor
   */
  public User() {

  }
}
