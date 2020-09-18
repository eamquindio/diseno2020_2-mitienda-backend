package co.edu.eam.disenosoftware.homeautobackend.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Store's class
 */
@Entity
@Table(name = "stores")
public class Store implements Serializable {

  /**
   * Store's - Primary key
   */
  @Id
  private Long id;

  /**
   * Store's name
   */
  private String name;

  /**
   * Store's owner
   */
  private String owner;

  /**
   * Store's address
   */
  private String address;

  /**
   * Store's image
   */
  private String image;

  /**
   * Store's delivery
   */
  private boolean delivery;

  /**
   * Store's is open
   */
  @Column(name = "is_open")
  private boolean isOpen;

  /**
   * Store's phone
   */
  private String phone;

  /**
   * Store's email
   */
  private String email;

  /**
   * Store's password
   */
  private  String password;

  /**
   * Store's constructors
   */
  public Store() {
  }


  /**
   * Store's constructor with params
   * @param id primary key
   */
  public Store(Long id) {
    this.id = id;
  }

  /**
   * Store's constructor with params
   * @param id primary key
   * @param name Store's name
   */
  public Store(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * Store's constructor with params
   * @param id primary key
   * @param email Store's email
   * @param name Store's name
   */
  public Store(Long id, String email, String name) {
    this.id = id;
    this.email = email;
    this.name = name;
  }


  /**
   * Get Store's name
   * @return Store's name
   */
  public String getName() {
    return name;
  }

  /**
   * Set Store's name
   * @param name Store's name
   */
  public void setName(String name) {
    this.name = name;
  }



  /**
   * Get Store's email
   * @return Store's email
   */
  public String getEmail()  {
    return email;
  }

  /**
   * Set Store's email
   * @param email Store's email
   */
  public void setEmail(String email) {
    this.email = email;
  }
}


