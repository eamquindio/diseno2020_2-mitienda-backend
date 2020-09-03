package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Class Order
 */
@Entity
@Table(name = "order")
public class Order implements Serializable {
  /**
  * Id Order
  */
  @Id
  private String id;

  /**
   * State Order
   */
  private String state;
  /**
   * Mapped Product
  */
  @OneToMany(mappedBy = "product")
  private List<OrderProduct> product;

  /**
   * Store order
   */
  @ManyToOne
  @JoinColumn(name = "id_store", referencedColumnName = "id")
  private Store store;

  /**
   * User user
   */
  @ManyToOne
  @JoinColumn(name = "id_user", referencedColumnName = "id")
  private User user;

  /**
   * Date order
   */
  private Date date;

  /**
   * Constructor order
   */
  public Order() {
  }
}
