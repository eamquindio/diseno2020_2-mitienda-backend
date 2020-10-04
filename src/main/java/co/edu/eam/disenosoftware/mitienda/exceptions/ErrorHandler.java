package co.edu.eam.disenosoftware.mitienda.exceptions;

import co.edu.eam.disenosoftware.mitienda.model.responses.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Generic Error handler
 */
@ControllerAdvice
public class ErrorHandler {

  /**
   * BusinessException Error Handler
   * @param req http request
   * @param exc business exception thrown
   * @return ErrorResponse
   */
  @ResponseBody
  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ErrorResponse> handleBusinessException(HttpServletRequest req, BusinessException exc) {

    ErrorCodesEnum errorCode = exc.getCode();
    ErrorResponse error = new ErrorResponse(errorCode.name(), errorCode.getCode());

    return new ResponseEntity<>(error, errorCode.getStatus());
  }
}
