package co.edu.eam.disenosoftware.homeautobackend.model.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Product's class
 */
@Entity
@Table(name = "tb_products")
public class Product implements Serializable {
  /**
   * Product's Id
   */
  @Id
  private Long id;
  /**
   * Product's image
   */

  private String image;
  /**
   * Product's name
   */

  private String name;

  /**
   * Product's constructor
   */
  public Product() {

  }

  /**
   * product get id
   *
   * @return , id
   */
  public Long getId() {
    return id;
  }

  /**
   * product set id
   *
   * @param id , id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * product get image
   *
   * @return , image
   */
  public String getImage() {
    return image;
  }

  /**
   * product set image
   *
   * @param image , image
   */
  public void setImage(String image) {
    this.image = image;
  }

  /**
   * product get name
   *
   * @return , name
   */
  public String getName() {
    return name;
  }

  /**
   * product set name
   *
   * @param name , name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * product to string
   *
   * @return , to string
   */
  @Override
  public String toString() {
    return "Product{"
            + "id=" + id
            + ", image='" + image + '\''
            + ", name='" + name + '\''
            + '}';
  }
}
