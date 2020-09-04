package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 Entity table stores
 */
@Entity
/**
 Table's name
 */
@Table(name = "stores")
public class Store implements Serializable {

  /**
   Prime key
   */
  @Id
  private String id;

  /**
   store's name
   */
  private String name;

  /**
   store's owner
   */
  private String owner;

  /**
   store's address
   */
  private String address;

  /**
   store's img
   */
  private String img;

  /**
   store's delivery
   */
  private boolean delivery;

  /**
   store's open
   */
  private boolean isOpen;

  /**
   store's phone
   */
  private String phone;

  /**
   store's email
   */
  private String email;

  /**
   store's password
   */
  private String password;

  /**
   builder of entity
   */
  public Store() {
  }
}
