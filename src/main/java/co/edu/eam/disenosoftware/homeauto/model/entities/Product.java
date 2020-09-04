package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 Entity table products
 */
@Entity
/**
 Table's name
 */
@Table(name = "products")
public class Product implements Serializable {

  /**
   Prime key of product
   */
  @Id
  private String id;

  /**
   Image for the product
   */
  private String image;

  /**
   name for the product
   */
  private String name;

  /**
   Builder of product
   */
  public Product() {
  }
}
