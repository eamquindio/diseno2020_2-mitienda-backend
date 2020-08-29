package co.edu.eam.disenosoftware.homeauto.mode.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "stores")
public class Store implements Serializable {

  public Store() {
  }

  @Id
  private String id;

  private String name;

  private String owner;

  private String address;

  private String image;

  private boolean delivery;

  @Column(name = "is_open")
  private boolean isOpen;

  private String phone;

  private String email;

  private String Password;

}
