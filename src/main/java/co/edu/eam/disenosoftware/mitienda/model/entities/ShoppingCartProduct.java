package co.edu.eam.disenosoftware.mitienda.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * Shopping cart of the product shopping cart's - Foreign Key
   */
  @JsonBackReference
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

  public ShoppingCartProduct(ShoppingCart shoppingCart, ProductStore product, int quantity) {
    this.shoppingCart = shoppingCart;
    this.product = product;
    this.quantity = quantity;
  }

  /**
   * ShoppingCartProduct's Get Id method
   *
   * @return id
   */
  public Long getId() {
    return id;
  }

  /**
   * ShoppingCartProduct's Set Id method
   *
   * @param id , id we want to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * ShoppingCartProduct's Get Shopping Cart method
   *
   * @return Shopping Cart
   */
  public ShoppingCart getShoppingCart() {
    return shoppingCart;
  }

  /**
   * ShoppingCartProduct's Set Shopping Cart method
   *
   * @param shoppingCart , Shopping cart we want to set
   */
  public void setShoppingCart(ShoppingCart shoppingCart) {
    this.shoppingCart = shoppingCart;
  }

  /**
   * ShoppingCartProduct's Get Product method
   *
   * @return Product
   */
  public ProductStore getProduct() {
    return product;
  }

  /**
   * ShoppingCartProduct's Set Product method
   *
   * @param product , product we want to set
   */
  public void setProduct(ProductStore product) {
    this.product = product;
  }

  /**
   * ShoppingCartProduct's Get Quantity method
   *
   * @return Quantity
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * ShoppingCartProduct's Set Quantity method
   *
   * @param quantity , Quantity we want to set
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
