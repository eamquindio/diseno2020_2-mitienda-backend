package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * entities store
 */

@Entity
@Table(name = "tb_store")
public class Store implements Serializable {

  /**
   * id store primary key
   */

  @Id
  @Column(name = "store_id")
  private Long id;

  /**
   * name store
   */

  @Column(name = "store_name")
  private String name;

  /**
   * owner store
   */

  @Column(name = "store_owner")
  private String owner;

  /**
   * address store
   */

  @Column(name = "store_address")
  private String address;

  /**
   * image store
   */

  @Column(name = "store_image")
  private String image;

  /**
   * delivery store
   */

  @Column(name = "store_delivery")
  private boolean delivery;

  /**
   * isOpen store
   */

  @Column(name = "store_isOpen")
  private boolean isOpen;

  /**
   * phone store
   */

  @Column(name = "store_phone")
  private String phone;

  /**
   * email store
   */

  @Column(name = "store_email")
  private String email;

  /**
   * password store
   */

  @Column(name = "store_password")
  private String password;

  /**
   * store builder
   */

  public Store() {
  }
}
