package co.edu.eam.disenosoftware.homeauto.mode.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "products_store")
public class ProductStore implements Serializable {

  public ProductStore() {
  }

  @Id
  private String id;

  @ManyToOne
  @JoinColumn(name = "id_product", referencedColumnName = "id")
  private Product product;

  private int stock;

  private double price;

  @ManyToOne
  @JoinColumn(name = "id_category", referencedColumnName = "id")
  private Category category;

  @ManyToOne
  @JoinColumn(name = "id_store", referencedColumnName = "id")
  private Store store;

}
