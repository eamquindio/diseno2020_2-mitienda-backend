package co.edu.eam.disenosoftware.mitienda.exceptions;

/**
 * Error codes for exceptions
 */
public enum ErrorCodesEnum {
  /**
   * code for not found error
   */
  NOT_FOUND("0000"),//ejemplo....
  /**
   * Shopping cart product not found
   */
  SHOPPING_CART_PRODUCT_NOT_FOUND("0001"),
  /**
   * Exception When Shopping Cart Product Doesnt exist
   */
  SHOPPING_CART_PRODUCT_NOT_FOUND("0001"),
  /**
   * Exception when User Exceed Five orders in progress
   */
  ORDER_USER_EXCEED_FIVE("0003"),
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
