package co.edu.eam.disenosoftware.mitienda.model.requests;

/**
 * storeRequest class
 */
public class StoreRequest {

  /**
   * email - store
   */
  private String email;

  /**
   * password - store
   */
  private String password;

  /**
   * Get email
   * @return email
   */
  public String getEmail() {
    return email;
  }

  /**
   * set email
   * @param email email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Get password
   * @return password
   */
  public String getPassword() {
    return password;
  }

  /**
   * set password
   * @param password password
   */
  public void setPassword(String password) {
    this.password = password;
  }
}
