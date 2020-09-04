package co.edu.eam.disenosoftware.homeautobackend.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product_store")
public class ProductStore {

  /**
   * Primary Key
   */
  @Id
  private Long id;

  /**
   * ProductStores product
   */
  @ManyToOne
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private Product product;

  /**
   * ProductStores stock
   */
  private int stock;

  /**
   * ProductStores price
   */
  private double price;

  /**
   * ProductStores category
   */
  @ManyToOne
  @JoinColumn(name = "category_id", referencedColumnName = "id")
  private Category category;


  /**
   * ProductStores store
   */
  private Store store;

  /**
   * Constructor
   */
  public ProductStore() {
  }
}
