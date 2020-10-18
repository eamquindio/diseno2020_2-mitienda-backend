package co.edu.eam.disenosoftware.mitienda.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Error codes for exceptions
 */
public enum ErrorCodesEnum {
  /**
   * code for not found error
   */
  NOT_FOUND("0000", HttpStatus.PRECONDITION_FAILED),
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
  ORDER_PRODUCT_NOT_FOUND("0012", HttpStatus.NOT_FOUND),
  /**
   * code for not order product pendind error
   */
  ORDER_PRODUCT_IS_NOT_PENDING("0013", HttpStatus.PRECONDITION_FAILED),
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
  ORDER_IS_NOT_READY("0016"),
  /**
   * store name already register
   */
  STORE_NAME_ALREADY_REGISTER("0017"),
  /**
   * store email already register
   */
  STORE_EMAIL_ALREADY_REGISTER("0018"),
  /**
   * login incorrect
   */
  LOGIN_INCORRECT("0019"),
  /**
   * email already exist
   */
  EMAIL_ALREADY_EXIST("0020"),
  /**
   * username already exist
   */
  USERNAME_ALREADY_EXIST("0021"),

  /**
   * the user name does not exist
   */
  THE_USER_NAME_DOES_NOT_EXIST("0022"),

  /**
   * username is not the same
   */
  USERNAME_IS_NOT_THE_SAME("0023"),

  /**
   * password is not the same
   */
  PASSWORD_IS_NOT_THE_SAME("0024"),
  /**
   * code for can not add product to Order
   */
  PRODUCT_CAN_NOT_BE_ADDED("0025"),
  /**
   * code for can not associated store to productstore
   */
  NOT_ASSOCIATED_STORE("0026"),
  /**
   * code for have been excited total value
   */
  PRODUCT_EXCIT_TOTALVALUE("0027"),

  /**
   * code for NOT_EXIST_ORDER_PRODUCT
   */
  NOT_EXIST_ORDER_PRODUCT("0028"),

  /**
   * code for NOT_STATE
   */
  NOT_STATE("0029"),
  /**
   * Order can not be delivered
   */
  ORDER_CAN_NOT_BE_DELIVERED("0030");
  /**
   * error code
   */
  private String code;

  /**
   * http status code associated to this error
   */
  private HttpStatus status;

  ErrorCodesEnum(String code) {
    this.code = code;
    status = HttpStatus.INTERNAL_SERVER_ERROR;
  }

  ErrorCodesEnum(String code, HttpStatus status) {
    this.code = code;
    this.status = status;
  }

  /**
   * get de error code description
   * @return error code
   */
  public String getCode() {
    return code;
  }

  /**
   * Get the status code associated to this error
   * @return http status code
   */
  public HttpStatus getStatus() {
    return status;
  }
}
