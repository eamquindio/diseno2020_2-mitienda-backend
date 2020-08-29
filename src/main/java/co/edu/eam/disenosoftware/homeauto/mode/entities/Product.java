package co.edu.eam.disenosoftware.homeauto.mode.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "products")
public class Product implements Serializable {

  public Product() {
  }

  @Id
  private String id;

  private String image;

  private String name;

}
