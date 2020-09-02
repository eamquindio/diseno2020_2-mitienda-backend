package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * entities user
 */

@Entity
@Table(name = "tb_user")
public class User implements Serializable {

  /**
   * username user
   */

  @Column(name = "user_username")
  private String username;

  /**
   * phone user
   */

  @Column(name = "user_phone")
  private String phone;

  /**
   * email user
   */

  @Column(name = "user_email")
  private String email;

  /**
   * password user
   */

  @Column(name = "user_password")
  private String password;

  /**
   * address user
   */

  @Column(name = "user_address")
  private String address;

  /**
   * name user
   */

  @Column(name = "user_name")
  private String name;

  /**
   * id user primary key
   */

  @Id
  @Column(name = "user_id")
  private Long id;

  /**
   * user builder
   */

  public User() {
  }
}
