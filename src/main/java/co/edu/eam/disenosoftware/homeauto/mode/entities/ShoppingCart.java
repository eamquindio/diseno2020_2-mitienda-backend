package co.edu.eam.disenosoftware.homeauto.mode.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "shopping_carts")
public class ShoppingCart implements Serializable {

  public ShoppingCart() {
  }

  @Id
  private String id;

  @ManyToOne
  @JoinColumn(name = "id_store", referencedColumnName = "id")
  private Store store;

  @OneToMany(mappedBy = "shoppingCart")
  private List<ShoppingCartProduct> products;

  @ManyToOne
  @JoinColumn(name = "id:user", referencedColumnName = "id")
  private User user;

}
