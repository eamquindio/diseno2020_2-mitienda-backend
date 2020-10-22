package co.edu.eam.disenosoftware.mitienda.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Category class
 */
@Entity
@Table(name = "categories")
public class Category implements Serializable {

  /**
   * Category - Primary key
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * Category icon
   */
  private String icon;

  /**
   * Category name
   */
  private String name;

  /**
   * Store categories - Foreign key
   */
  @ManyToOne
  @JoinColumn(name = "id_store", referencedColumnName = "id")
  private Store store;

  /**
   * Category's constructors
   */
  public Category() {
  }

  public Category(String icon, String name, Store store) {
    this.icon = icon;
    this.name = name;
    this.store = store;
  }

  /**
   * category's Get Id method
   *
   * @return id
   */
  public Long getId() {
    return id;
  }

  /**
   * category's Set method
   *
   * @param id , id we want to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Store getStore() {
    return store;
  }

  public void setStore(Store store) {
    this.store = store;
  }
}
