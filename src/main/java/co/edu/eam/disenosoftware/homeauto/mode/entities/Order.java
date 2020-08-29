package co.edu.eam.disenosoftware.homeauto.mode.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

  public Order() {
  }

  @Id
  private String id;

  @OneToMany(mappedBy = "order")
  private List<OrderProduct> product;

  @ManyToOne
  @JoinColumn(name = "id_store", referencedColumnName = "id")
  private Store store;

  @ManyToOne
  @JoinColumn(name = "id_user", referencedColumnName = "id")
  private User user;

  private String state;

  private Date date;

}
