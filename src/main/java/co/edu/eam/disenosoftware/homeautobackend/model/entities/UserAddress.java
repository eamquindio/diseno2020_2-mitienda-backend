package co.edu.eam.disenosoftware.homeautobackend.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * User address Entity
 */
@Entity
@Table(name = "user_addresses")
public class UserAddress implements Serializable {

  /**
   * Primary Key
   */
  @Id
  private Long id;

  /**
   * User's order - Foreign key
   */
  @ManyToOne
  @JoinColumn(name = "id_user", referencedColumnName = "id")
  private User user;

  /**
   * User adress
   */
  private String address;

  /**
   * Constructor
   */
  public UserAddress() {
  }

  /**
   * Constructor with params
   */
  public UserAddress(Long id, User user, String address) {
    this.id = id;
    this.user = user;
    this.address = address;
  }
}
