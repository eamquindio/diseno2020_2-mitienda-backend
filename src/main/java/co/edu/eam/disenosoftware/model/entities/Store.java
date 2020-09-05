package co.edu.eam.disenosoftware.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entities store
 */

@Entity
@Table(name = "stores")
public class Store implements Serializable {

  /**
   * Id store primary key
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
   * delivery store
   */

  private boolean delivery;

  /**
   * isOpen store
   */

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
   * store builder
   */
  public Store() {
  }
}
