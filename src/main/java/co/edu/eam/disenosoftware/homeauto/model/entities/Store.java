package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Class Store
 */
@Entity
@Table(name = "store")
public class Store implements Serializable {

  /**
   * Store Name
   */
  private String name;

  /**
   * Owner Store
   */
  private String owner;

  /**
   * address Store
   */
  private String address;

  /**
   * image Store
   */
  private String image;

  /**
   * Disponibility Store
   */
  @Column(name = "is_open")
  private boolean isOpen;

  /**
   * Phone Store
   */
  private String phone;

  /**
   * email Store
   */
  private String email;

  /**
   * password Store
   */
  private String password;

  /**
   * ID store
   */
  @Id
  private Long id;

  /**
   * Constructor Store
   */
  public Store() {
  }
}
