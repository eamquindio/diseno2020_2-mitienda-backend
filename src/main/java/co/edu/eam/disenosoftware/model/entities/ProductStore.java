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
   * store product store llave foranea
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

  @ManyToOne
  @JoinColumn(name = "id_store", referencedColumnName = "id")
  private Store store;

  /**
   * ManyToOne category
   */
  @ManyToOne
  @JoinColumn(name = "category_id", referencedColumnName = "id")
  private Category category;

  /**
   * mappedBy productStore
   */
  @OneToMany(mappedBy = "productStore")
  private List<ShoppingCartProduct> shoppingCartProducts;

  /**
   * ManyToOne products
   */
  @ManyToOne
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private Product products;

  /**
   * product store builder
   */

  public ProductStore() {
  }
}
