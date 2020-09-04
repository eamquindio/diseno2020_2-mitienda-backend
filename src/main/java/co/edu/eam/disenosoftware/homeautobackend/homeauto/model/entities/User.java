package co.edu.eam.disenosoftware.homeautobackend.homeauto.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

  /**
   * Primary Key
   */
  @Id
  private Long id;

  /**
   * Users UserName
   */
  @Column(name = "user_name")
  private String userName;

  /**
   * Users phone
   */
  private String phone;

  /**
   * Users email
   */
  private String email;

  /**
   * Users password
   */
  private String password;

  /**
   * Users address
   */
  private String address;

  /**
   * Users name
   */
  private String name;

  /**
   * Users order
   */
  @OneToMany(mappedBy = "user_name")
  private List<Order> order;

  /**
   * Constructor
   */
  public User() {
  }
}
