package co.edu.eam.disenosoftware.mitienda.exceptions;

/**
 * Error codes for exceptions
 */
public enum ErrorCodesEnum {
  /**
   * code for not found error
   */
  NOT_FOUND("0000"), //ejemplo....
  /**
   * Shopping cart product not found
   */
  SHOPPING_CART_EMPTY("0001"),
  /**
   * Exception when User Exceed Five orders in progress
   */
  NUMBER_OF_ORDERS_EXCEDED("0003"),
  /**
   * Exception when shopping cart doesnt exist
   */
  SHOPPING_CART_NOT_FOUND("0004");

  /**
   * error code
   */
  private String code;

  ErrorCodesEnum(String code) {
    this.code = code;
  }

  /**
   * get de error code description
   * @return error code
   */
  public String getCode() {
    return code;
  }
}
