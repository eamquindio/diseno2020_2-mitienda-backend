package co.edu.eam.disenosoftware.homeauto.model.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Product store's: class
 */
@Entity
@Table(name = "tb_product_store")
public class ProductStore {

  /**
   * Product store's id
   */
  @Id
  @Column(name = "product_store_id")
  private String id;

  /**
   * Product store's: product
   */
  @ManyToOne
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private Product product;

  /**
   * Product store's stock
   */
  @Column(name = "product_store_stock")
  private int stock;

  /**
   * Product store's price
   */
  @Column(name = "product_store_price")
  private double price;
  /**
   * Product store's: category
   */
  @ManyToOne
  @JoinColumn(name = "category_id", referencedColumnName = "id")
  private Category category;

  /**
   * Product store's: store
   */
  @ManyToOne
  @JoinColumn(name = "store_id", referencedColumnName = "id")
  private Store store;


  /**
   * Product store's constructor
   */

  public ProductStore() {

  }
}
