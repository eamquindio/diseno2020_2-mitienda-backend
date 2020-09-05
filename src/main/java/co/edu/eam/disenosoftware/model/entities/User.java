package co.edu.eam.disenosoftware.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entities user
 */

@Entity
@Table(name = "users")
public class User implements Serializable {

  /**
   * Id user primary key
   */

  @Id
  private Long id;

  /**
   * username user
   */

  private String username;

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
   * OneToOne order
   */
  @OneToOne
  private Order orders;

  /**
   * user builder
   */

  public User() {
  }
}
