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
 * Order Class
 */
@Entity
@Table(name = "orders")
public class Order implements Serializable {

 /**
  * Mappeado Order
  */

  @OneToMany(mappedBy = "order")
  private List<OrderProduct> product;

  /**
  * Objet Store
  */
  @ManyToOne
  @JoinColumn(name = "id_store", referencedColumnName = "id")
  private Store store;

  /**
  * user order
  */
  @ManyToOne
  @JoinColumn(name = "id_user", referencedColumnName = "id")
  private User user;

  /**
  * state Order
  */
  private String state;

  /**
  * Order Date
  */
  private Date date;

  /**
  * ID order
  */
  @Id
  private Long id;

  /**
  * Order Constructor
  */
  public Order() {
  }
}
