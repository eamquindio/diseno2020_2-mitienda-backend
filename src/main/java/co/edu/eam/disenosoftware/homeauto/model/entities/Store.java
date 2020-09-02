package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * Store's class
 */
@Entity
@Table(name = "tb_store")
public class Store implements Serializable {

  /**
   * Store's id
   */
  @Id
  @Column(name = "store_id")
  private String id;

  /**
   * Store's name
   */
  @Column(name = "store_name")
  private String name;

  /**
   * Store's owner
   */
  @Column(name = "store_owner")
  private String owner;

  /**
   * Store's image
   */
  @Column(name = "store_image")
  private String image;

  /**
   * Store's address
   */
  @Column(name = "store_address")
  private String address;

  /**
   * Store's delivery
   */
  @Column(name = "store_delivery")
  private boolean delivery;

  /**
   * Store's isOpen
   */
  @Column(name = "store_is_open")
  private boolean isOpen;

  /**
   * Store's phone
   */
  @Column(name = "store_phone")
  private String phone;
  /**
   * Store's email
   */
  @Column(name = "store_email")
  private String email;

  /**
   * Store's password
   */
  @Column(name = "store_password")
  private String password;

  /**
   * Store's constructor
   */
  public Store() {

  }
}
