package co.edu.eam.disenosoftware.homeauto.mode.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

  public User() {
  }

  @Id
  private String id;

  private String username;

  private String phone;

  private String email;

  private String password;

  private String address;

  private String name;

}
