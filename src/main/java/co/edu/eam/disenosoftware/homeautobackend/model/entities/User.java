package co.edu.eam.disenosoftware.homeautobackend.model.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * User's class
 */
@Entity
@Table(name = "tb_users")
public class User implements Serializable {

  /**
   * User's identification
   */
  @Id
  private Long id;

  /**
   * User's name
   */

  private String name;

  /**
   * User's address
   */

  private String address;

  /**
   * User's password
   */

  private String password;

  /**
   * User's email
   */

  private String email;

  /**
   * User's phone
   */

  private String phone;

  /**
   * User's username
   */

  private String username;

  /**
   * User's constructor
   */
  public User() {

  }

  /**
   * get user's id
   *
   * @return , id
   */
  public Long getId() {
    return id;
  }

  /**
   * set user's id
   *
   * @param id , id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * get users name
   *
   * @return , name
   */
  public String getName() {
    return name;
  }

  /**
   * set users name
   *
   * @param name , name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * get users address
   *
   * @return , address
   */
  public String getAddress() {
    return address;
  }

  /**
   * set users address
   *
   * @param address , address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * get users password
   *
   * @return , password
   */
  public String getPassword() {
    return password;
  }

  /**
   * set users password
   *
   * @param password , password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * get users mail
   *
   * @return , mail
   */
  public String getEmail() {
    return email;
  }


  /**
   * user
   *
   * @param email , email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * get users phone
   *
   * @return , phone
   */
  public String getPhone() {
    return phone;
  }

  /**
   * set users phone
   *
   * @param phone , phone
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * get username
   *
   * @return , username
   */
  public String getUsername() {
    return username;
  }

  /**
   * set username
   *
   * @param username , username
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Users to string method
   *
   * @return , to string method
   */
  @Override
  public String toString() {
    return "User{"
            + "id=" + id
            + ", name='" + name + '\''
            + ", address='" + address + '\''
            + ", password='" + password + '\''
            + ", email='" + email + '\''
            + ", phone='" + phone + '\''
            + ", username='" + username + '\''
            + '}';
  }
}
