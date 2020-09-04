package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * class store
 */
@Entity
@Table(name = "store")
public class Store implements Serializable {

  /**
   * id store
   */
  @Id
  private Long id;

  /**
   * name store
   */
  private String name;

  /**
   * owner store
   */
  private String owner;

  /**
   * address store
   */
  private String address;

  /**
   * image store
   */
  private String image;

  /**
   * condition is Open store
   */
  @Column(name = "is_open")
  private boolean isOpen;

  /**
   * phone store
   */
  private String phone;

  /**
   * email store
   */
  private String email;

  /**
   * password store
   */
  private String password;

  /**
   * builder store
   */
  public Store() {
  }
}
