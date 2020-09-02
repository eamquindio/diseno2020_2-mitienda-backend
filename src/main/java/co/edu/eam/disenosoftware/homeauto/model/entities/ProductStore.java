package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * entities productStore
 */

@Entity
@Table(name = "tb_productStore")
public class ProductStore implements Serializable {

  /**
   * store product store
   */

  @Column(name = "productStore_product")
  private Product product;

  /**
   * store product values
   */

  @Column(name = "productStore_stock")
  private int stock;

  /**
   * store product price
   */

  @Column(name = "productStore_price")
  private double price;

  /**
   * product store category
   */

  @Column(name = "productStore_category")
  private Category category;

  /**
   * product store shop
   */

  @Column(name = "productStore_store")
  private Store store;

  /**
   * id productStore primary key
   */

  @Id
  @Column(name = "productStore_id")
  private Long id;

  /**
   * product store builder
   */

  public ProductStore() {
  }
}
