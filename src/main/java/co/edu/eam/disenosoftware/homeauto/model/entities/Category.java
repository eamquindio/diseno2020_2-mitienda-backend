package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Class Category
 */
@Entity
@Table(name = "category")
public class Category implements Serializable {

  /**
  * Id Category
  */
  @Id
  private String id;

  /**
  * Icon Category
  */
  private String icon;

  /**
  * Storeld Category
  */
  private String storeld;

  /**
  * Name Category
  */
  private String name;

  /**
  * Constructor Category
  */
  public Category() {
  }
}
