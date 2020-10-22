package co.edu.eam.disenosoftware.mitienda.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import co.edu.eam.disenosoftware.mitienda.model.entities.OrderProduct;
import co.edu.eam.disenosoftware.mitienda.model.requests.AddProductToOrderRequest;
import co.edu.eam.disenosoftware.mitienda.services.OrderProductService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Controller for orders entity
 */
@RestController
@RequestMapping("/api/orders")
public class OrdersController {

  /**
   * Injecting OrderService class
   */
  @Autowired
  private OrderService orderService;

  /**
   * Autowired
   * Order product service
   */
  @Autowired
  private OrderProductService orderProductService;

  /**
   * get order by id API
   * @param id to find
   * @return order found
   */
  @GetMapping("/{id}")
  public Order getOrderById(@PathVariable("id") Long id) {
    return orderService.getOrderByID(id);
  }

  /**
   * end order API
   * @param id of order to end
   */
  @PatchMapping("/{id}/end")
  public void endOrder(@PathVariable("id") Long id) {
    orderService.finalizeOrder(id);
  }

  /**
   * URL: orders/{order_id}/delivery
   * verbo:POST
   * parametros: {name,phone,username,email,password}
   * @param orderId  ,Long
   */
  @PatchMapping("/{orderId}/delivery")
  public void deliverOrder(@PathVariable("orderId") Long orderId) {
    orderService.deliverOrder(orderId);

  }

  /**
   * URI: ("/{id_order}/add-product")
   * Verb: PUT
   * Add product to Order
   * @param id primary key
   * @param addProductToOrderRequest request from add product to order
   * @return Order Product
   */
  @PutMapping("/{id_order}/add-product")
  public OrderProduct addProductToOrder(@PathVariable("id_order") Long id,
                                        @RequestBody @Valid AddProductToOrderRequest addProductToOrderRequest) {
    return orderProductService.addingProductToOrderProduct(addProductToOrderRequest.getId(),
            id,
            addProductToOrderRequest.getQuantity());
  }

}
