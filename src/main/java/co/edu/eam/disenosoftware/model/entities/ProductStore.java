package co.edu.eam.disenosoftware.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Entities productStore
 */

@Entity
@Table(name = "productStores")
public class ProductStore implements Serializable {

  /**
   * Id productStore primary key
   */
  @Id
  private Long id;

  /**
   * store product store
   */

  private Product product;

  /**
   * store product values
   */

  private int stock;

  /**
   * store product price
   */

  private double price;

  /**
   * product store shop
   */

  private Store store;

  @ManyToOne
  @JoinColumn(name = "category_id", referencedColumnName = "id")
  private Category category;

  @OneToMany(mappedBy = "productStore")
  private List<ShoppingCartProduct> shoppingCartProducts;

  @ManyToOne
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private Product products;

  /**
   * product store builder
   */

  public ProductStore() {
  }
}
