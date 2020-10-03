package co.edu.eam.disenosoftware.mitienda.exceptions;

/**
 * Generic exception
 */
public class BusinessException extends RuntimeException {

  /**
   * error code
   */
  private ErrorCodesEnum code;

  /**
   * Constructor
   * @param message exception message
   * @param code exception code
   */
  public BusinessException(String message, ErrorCodesEnum code) {
    super(message);
    this.code = code;
  }

  /**
   * get exception code
   * @return error code
   */
  public ErrorCodesEnum getCode() {
    return code;
  }
}

