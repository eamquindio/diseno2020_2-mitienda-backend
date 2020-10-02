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
  SHOPPING_CART_PRODUCT_NOT_FOUND("0001"),
  /**
   * Product store not found
   */
  PRODUCT_STORE_NOT_FOUNDED("0002"),
  /**
<<<<<<< HEAD
   * Exception when User Exceed Five orders in progress
   */
  NUMBER_OF_ORDERS_EXCEDED("0003"),
  /**
   * Exception when shopping cart doesnt exist
   */
  SHOPPING_CART_NOT_FOUND("0004"),

  /**
   * Shopping cart is empty
    */
  SHOPPING_CART_EMPTY("0005"),;
=======
   * User is not founded
   */
  USER_NOT_FOUNDED("0003"),
  /**
   * Store is not founded
   */
  STORE_NOT_FOUNDED("0004");
>>>>>>> eb4bbff... Adding an user and store null validation and changing test to sql format

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
