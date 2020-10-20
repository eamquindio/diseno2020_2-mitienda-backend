package co.edu.eam.disenosoftware.mitienda.controllers;

import co.edu.eam.disenosoftware.mitienda.services.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for orders entity
 */
@RestController
@RequestMapping("/api/order-products")
public class OrderProductController {

  /**
   * Order product service
   */
  @Autowired
  private OrderProductService orderProductService;

  /**
   * URL: /{order-product-id}/check-product
   * Verbo: Put
   * Retorno: only status.
   * @param orderProductId id from order product
   */
  @PutMapping
  @RequestMapping("/{orderProductId}/check-product")
  public void checkOrderProduct(@PathVariable Long orderProductId) {
    orderProductService.checkOrderProductById(orderProductId);
  }

}
