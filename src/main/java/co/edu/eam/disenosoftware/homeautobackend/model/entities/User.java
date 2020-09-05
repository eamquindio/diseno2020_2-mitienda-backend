package co.edu.eam.disenosoftware.homeautobackend.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 Entity table users
 */
@Entity
/**
 Table's name
 */
@Table(name = "users")
public class User implements Serializable {
  /**
   Prime key
   */
  @Id
  private String id;

  /**
   user's username
   */
  @Column(name = "user_name")
  private String userName;

  /**
   user's phone
   */
  private String phone;

  /**
   user's email
   */
  private String email;

  /**
   user's password
   */
  private String password;

  /**
   user's address
   */
  private String addreess;

  /**
   user's name
   */
  private String name;

  /**
   builder of entity
   */
  public User() {
  }
}
