package co.edu.eam.disenosoftware.homeautobackend.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {

  /**
   * Primary Key
   */
  @Id
  private Long id;

  /**
   * List of OrderProducts
   */
  @OneToMany(mappedBy = "order")
  private List<OrderProduct> order_product;

  /**
   * Orders store
   */
  @ManyToOne
  @JoinColumn(name = "store", referencedColumnName = "id")
  private Store store;

  /**
   * Orders user
   */
  @ManyToOne
  @JoinColumn(name = "userName", referencedColumnName = "id")
  private User user_name;

  /**
   * Orders state
   */
  private String state;

  /**
   * Orders date
   */
  private Date date;

  /**
   * Constructor
   */
  public Order() {
  }
}
