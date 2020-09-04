package co.edu.eam.disenosoftware.model.entities;

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
 * Entities order
 */

@Entity
@Table(name = "orders")
public class Order implements Serializable {

  /**
   * Id order primary key
   */

  @Id
  private Long id;

  /**
   * store order
   */

  private Store store;

  /**
   * user order
   */

  private User user;

  /**
   * state order
   */

  private String state;

  /**
   * date order
   */

  private Date date;

  @OneToMany(mappedBy = "order")
  private List<OrderProduct> orderProducts;

  @ManyToOne
  @JoinColumn(name = "id_users" , referencedColumnName = "id")
  private User users;

  /**
   * constructor order
   */

  public Order() {

  }
}
