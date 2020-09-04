package co.edu.eam.disenosoftware.homeautobackend.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 Entity table products
 */
@Entity
/**
 Table's name
 */
@Table(name = "protucts_store")
public class ProductStore implements Serializable {

  /**
   Prime key of product store
   */
  @Id
  private Long code;

  /**
   Relation with product
   */
  @ManyToOne
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private Product product;

  /**
   Product's stock
   */
  private int stock;

  /**
   Product's price
   */
  private double price;

  /**
   Relation with entity category
   */
  @ManyToOne
  @JoinColumn(name = "category_id", referencedColumnName = "id")
  private Category category;

  /**
   Relation with entity store
   */
  @ManyToOne
  @JoinColumn(name = "store_id", referencedColumnName = "id")
  private Store store;

  /**
   Id of the product store
   */
  private String id;

  /**
   Builder of product store
   */
  public ProductStore() {
  }
}
