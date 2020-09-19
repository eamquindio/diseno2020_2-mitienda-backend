package co.edu.eam.disenosoftware.mitienda.exceptions;

/**
 * Exception thown when a resource is not found
 */
public class NotFoundException extends RuntimeException {

  /**
   * error code for the exception
   */
  private ErrorCodesEnum errorCode;

  /**
   * Constructor
   */
  public NotFoundException() {
    super("resource not found");
    errorCode = ErrorCodesEnum.NOT_FOUND;
  }

  /**
   * Constructor
   * @param message message
   * @param errorCode errorCode
   */
  public NotFoundException(String message, ErrorCodesEnum errorCode) {
    super(message);
    this.errorCode = errorCode;
  }

  /**
   * COnstructor
   * @param errorCode errorCode
   */
  public NotFoundException(ErrorCodesEnum errorCode) {
    this.errorCode = errorCode;
  }

  /**
   * get error code
   * @return errorCode
   */
  public ErrorCodesEnum getErrorCode() {
    return errorCode;
  }
}
