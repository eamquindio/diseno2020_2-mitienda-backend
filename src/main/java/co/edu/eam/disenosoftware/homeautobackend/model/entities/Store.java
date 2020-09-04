package co.edu.eam.disenosoftware.homeautobackend.model.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * Store's class
 */
@Entity
@Table(name = "tb_stores")
public class Store implements Serializable {

  /**
   * Store's id
   */
  @Id
  private Long id;

  /**
   * Store's name
   */

  private String name;

  /**
   * Store's owner
   */

  private String owner;

  /**
   * Store's image
   */

  private String image;

  /**
   * Store's address
   */

  private String address;

  /**
   * Store's delivery
   */

  private boolean delivery;

  /**
   * Store's isOpen
   */
  @Column(name = "is_open")
  private boolean isOpen;

  /**
   * Store's phone
   */

  private String phone;
  /**
   * Store's email
   */

  private String email;

  /**
   * Store's password
   */

  private String password;

  /**
   * Store's constructor
   */
  public Store() {

  }

  /**
   * stores get id
   *
   * @return , id
   */
  public Long getId() {
    return id;
  }

  /**
   * stores set id
   *
   * @param id , id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * stores get name
   *
   * @return , name
   */
  public String getName() {
    return name;
  }

  /**
   * stores set name
   *
   * @param name , name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * stores get owner
   *
   * @return , owner
   */
  public String getOwner() {
    return owner;
  }

  /**
   * stores set owner
   *
   * @param owner , owner
   */
  public void setOwner(String owner) {
    this.owner = owner;
  }

  /**
   * stores get image
   *
   * @return , image
   */
  public String getImage() {
    return image;
  }

  /**
   * stores set image
   *
   * @param image , image
   */
  public void setImage(String image) {
    this.image = image;
  }

  /**
   * stores get address
   *
   * @return , address
   */
  public String getAddress() {
    return address;
  }

  /**
   * stores set address
   *
   * @param address , address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * stores get is delivery
   *
   * @return , is delivery
   */
  public boolean isDelivery() {
    return delivery;
  }

  /**
   * stores set is delivery
   *
   * @param delivery , is delivery
   */
  public void setDelivery(boolean delivery) {
    this.delivery = delivery;
  }

  /**
   * stores get is open
   *
   * @return , is open
   */
  public boolean isOpen() {
    return isOpen;
  }

  /**
   * stores set is open
   *
   * @param open , is open
   */
  public void setOpen(boolean open) {
    isOpen = open;
  }

  /**
   * stores get phone
   *
   * @return , phone
   */
  public String getPhone() {
    return phone;
  }

  /**
   * stores set phone
   *
   * @param phone , phone
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * stores get email
   *
   * @return , email
   */
  public String getEmail() {
    return email;
  }

  /**
   * stores set email
   *
   * @param email , email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * stores get password
   *
   * @return , password
   */
  public String getPassword() {
    return password;
  }

  /**
   * stores set password
   *
   * @param password , password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * stores to string
   *
   * @return , to string
   */
  @Override
  public String toString() {
    return "Store{"
            + "id=" + id
            + ", name='" + name + '\''
            + ", owner='" + owner + '\''
            + ", image='" + image + '\''
            + ", address='" + address + '\''
            + ", delivery=" + delivery
            + ", isOpen=" + isOpen
            + ", phone='" + phone + '\''
            + ", email='" + email + '\''
            + ", password='" + password + '\''
            + '}';
  }
}
