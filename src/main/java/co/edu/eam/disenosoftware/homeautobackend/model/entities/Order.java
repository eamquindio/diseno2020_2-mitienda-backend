package co.edu.eam.disenosoftware.homeautobackend.model.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 Entity table order
 */
@Entity
/**
 Table's name
 */
@Table(name = "orders")
public class Order implements Serializable {

  /**
   Prime key Entity orders
   */
  @Id
  private String id;
  /**
   List of orders products
   */
  @OneToMany
  private List<OrderProduct> orderProducts;

  /**
   Strore's relation with order
   */
  @ManyToOne
  @JoinColumn(name = "store_id", referencedColumnName = "id")
  private Store store;

  /**
   User's relation with order
   */
  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;

  /**
   State of the order
   */
  private String state;

  /**
   Date of the order
   */
  private Date date;

  public Order() {
  }
}
