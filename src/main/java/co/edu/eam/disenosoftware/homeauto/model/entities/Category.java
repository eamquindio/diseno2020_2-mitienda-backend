package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * entities category
 */

@Entity
@Table(name = "tb_category")
public class Category implements Serializable {

  /**
   * id category primary key
   */

  @Id
  @Column(name = "category_id")
  private Long id;

  /**
   * icon category
   */

  @Column(name = "category_icon")
  private String icon;

  /**
   * store category
   */

  @Column(name = "category_store")
  private Store store;

  /**
   * name category
   */

  @Column(name = "category_name")
  private String name;

  /**
   * constructor category
   */

  public Category() {
  }
}
