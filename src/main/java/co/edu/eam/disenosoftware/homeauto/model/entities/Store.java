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
   * Id Store
   */
  @Id
  private String id;

  /**
   * Name Store
   */
  private String name;

  /**
   * Owner Store
   */
  private String owner;

  /**
   * Address Store
   */
  private String address;

  /**
   * Image Store
   */
  private String image;

  /**
   * Delivery Store
   */
  private boolean delivery;

  /**
   * Store Open or not
   */
  @Column(name = "is_open")
  private boolean isOpen;

  /**
   * Phone Store
   */
  private String phone;

  /**
   * Email Store
   */
  private String email;

  /**
   * Password Store
   */
  private String password;

  /**
   * Constructor Store
   */
  public Store() {
  }
}
