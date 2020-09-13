package co.edu.eam.disenosoftware.homeautobackend.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Shopping Cart's Product class
 */
@Entity
@Table(name = "shopping_cart_products")
public class ShoppingCartProduct implements Serializable {

  /**
   * Shopping Cart's Product's - Primary key
   */
  @Id
  private Long id;

  /**
   * Shopping cart of the product shopping cart's - Foreign Key
   */
  @ManyToOne
  @JoinColumn(name = "id_shopping_cart", referencedColumnName = "id")
  private ShoppingCart shoppingCart;

  /**
   * Shopping Cart's Product
   */
  @ManyToOne
  @JoinColumn(name = "id_product_store", referencedColumnName = "id")
  private ProductStore product;

  /**
   * Shopping Cart's Product quantity
   */
  private int quantity;

  /**
   * Shopping Cart's Product constructor
   */
  public ShoppingCartProduct() {
  }

  public ShoppingCartProduct(Long id, ShoppingCart shoppingCart, ProductStore product, int quantity) {
    this.id = id;
    this.shoppingCart = shoppingCart;
    this.product = product;
    this.quantity = quantity;
  }

  /**
   * ShoppingCartProducts's Get Id method
   * @return id
   */
  public Long getId() {
    return id;
  }

  /**
   * ShoppingCartProducts's Set Id method
   * @param id , id we want to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * ShoppingCartProducts's Get Shopping Cart method
   * @return Shopping Cart
   */
  public ShoppingCart getShoppingCart() {
    return shoppingCart;
  }

  /**
   * ShoppingCartProducts's Set Shopping Cart method
   * @param shoppingCart , Shopping cart we want to set
   */
  public void setShoppingCart(ShoppingCart shoppingCart) {
    this.shoppingCart = shoppingCart;
  }

  /**
   * ShoppingCartProducts's Get Product method
   * @return Product
   */
  public ProductStore getProduct() {
    return product;
  }

  /**
   * ShoppingCartProducts's Set Product method
   * @param product , product we want to set
   */
  public void setProduct(ProductStore product) {
    this.product = product;
  }

  /**
   * ShoppingCartProducts's Get Quantity method
   * @return Quantity
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * ShoppingCartProducts's Set Quantity method
   * @param quantity , Quantity we want to set
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
