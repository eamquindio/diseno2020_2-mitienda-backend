package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Categories class
 */
@Entity
@Table(name = "tb_category")
public class Category {

  /**
   * Categories id
   */
  @Id
  @Column(name = "category_id")
  private String id;

  /**
   * Categories icon
   */
  @Column(name = "icon")
  private String icon;

  /**
   * Categories icon
   */
  @ManyToOne
  @JoinColumn(name = "id_store", referencedColumnName = "id")
  private Store storeId;

  /**
   * Categories name
   */
  @Column(name = "name")
  private String name;

  /**
   * Categories constructor
   */
  public Category() {

  }
}
