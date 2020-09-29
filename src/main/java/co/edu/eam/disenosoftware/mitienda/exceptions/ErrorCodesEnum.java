package co.edu.eam.disenosoftware.mitienda.exceptions;

/**
 * Error codes for exceptions
 */
public enum ErrorCodesEnum {
  /**
   * code for not found error
   */
  NOT_FOUND("0000"),; //ejemplo....

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
