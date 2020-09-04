package co.edu.eam.disenosoftware.homeautobackend.model.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Categories class
 */
@Entity
@Table(name = "tb_categories")
public class Category implements Serializable {

  /**
   * Categories id
   */
  @Id
  private Long id;

  /**
   * Categories icon
   */

  private String icon;

  /**
   * Categories store
   */
  @ManyToOne
  @JoinColumn(name = "id_store", referencedColumnName = "id")
  private Store store;

  /**
   * Categories name
   */

  private String name;

  /**
   * Categories constructor
   */
  public Category() {

  }


  /**
   * category get id
   *
   * @return , id
   */
  public Long getId() {
    return id;
  }

  /**
   * category set id
   *
   * @param id , id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * category get icon
   *
   * @return , icon
   */
  public String getIcon() {
    return icon;
  }

  /**
   * category set icon
   *
   * @param icon , icon
   */
  public void setIcon(String icon) {
    this.icon = icon;
  }

  /**
   * category get store
   *
   * @return , store
   */
  public Store getStore() {
    return store;
  }

  /**
   * category set store
   *
   * @param store , store
   */
  public void setStore(Store store) {
    this.store = store;
  }

  /**
   * category get name
   *
   * @return , name
   */
  public String getName() {
    return name;
  }

  /**
   * category set name
   *
   * @param name , name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * category to string
   *
   * @return , to string
   */
  @Override
  public String toString() {
    return "Category{"
            + "id=" + id
            + ", icon='" + icon + '\''
            + ", store=" + store
            + ", name='" + name + '\''
            + '}';
  }
}
