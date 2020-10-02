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
  SHOPPING_CART_EMPTY("0005"),
  /**
   * Store is not founded
   */
  STORE_NOT_FOUNDED("0006"),
  /**
   * User is not founded
   */
  USER_NOT_FOUNDED("0007"),
  /**
   * code for not found store
   */
  NOT_FOUND_STORE("0008"),
  /**
   * code for name category in use
   */
  NAME_CATEGORY_IN_USE("0009"),
  /**
   * code for not found product
   */
  NOT_FOUND_PRODUCT("0010"),
  /**
   * code for not found category
   */
  NOT_FOUND_CATEGORY("0011"),
  /**
   * code for not order product found error
   */
  ORDER_PRODUCT_NOT_FOUND("0012"),
  /**
   * code for not order product pendind error
   */
  ORDER_PRODUCT_IS_NOT_PENDING("0013"),
  /**
   * code for not order found error
   */
  ORDER_NOT_FOUND("0014"),
  /**
   * code for order withour elements
   */
  ORDER_DOES_NOT_HAVE_ELEMENTS("0015"),
  /**
   * code for not existing order
   */
  ORDER_IS_NOT_READY("0016");
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
