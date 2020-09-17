package co.edu.eam.disenosoftware.homeautobackend.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Product's class
 */
@Entity
@Table(name = "products")
public class Product implements Serializable {

  /**
   * Product's - Primary key
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
   * Product's constructors clear
   */
  public Product() {
  }

  /**
   * Product's constructor to Id
   * @param id , id parameter
   */
  public Product(Long id) {
    this.id = id;
  }

  /**
   * Product's constructor
   * @param id , id parameter
   * @param image , image parameter
   * @param name , name parameter
   */
  public Product(Long id, String image, String name) {
    this.id = id;
    this.image = image;
    this.name = name;
  }

  /**
   * product's get id function
   *
   * @return , product's id
   */
  public Long getId() {
    return id;
  }

  /**
   * product's set id function
   *
   * @param id , set a product's id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * product's get image function
   *
   * @return , product's image
   */
  public String getImage() {
    return image;
  }

  /**
   * product's set image function
   *
   * @param image , product's image
   */
  public void setImage(String image) {
    this.image = image;
  }

  /**
   * product's get name function
   *
   * @return , product's name
   */
  public String getName() {
    return name;
  }

  /**
   * product's set name function
   *
   * @param name , product's name
   */
  public void setName(String name) {
    this.name = name;
  }

}
