package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * Order's class
 */
@Entity
@Table(name = "tb_order")
public class Order {
  /**
   * Order's id
   */
  @Id
  @Column(name = "order_id")
  private String id;
  /**
   * Order: list of product's
   */
  @OneToMany
  @JoinTable(name = "tb_order_to_order_product",
          joinColumns = @JoinColumn(name = "order"),
          inverseJoinColumns = @JoinColumn(name = "order_product"))
  private List<OrderProduct> product;

  /**
   * Order: list of store's
   */
  @ManyToOne
  @JoinColumn(name = "store_id", referencedColumnName = "id")
  private Store store;

  /**
   * Order: list of user's
   */
  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User userName;

  /**
   * Order's state
   */
  @Column(name = "state")
  private String state;

  /**
   * Order's date
   */
  @Column(name = "date")
  private Date date;


  /**
   * Order's constructor
   */
  public Order() {

  }

}
