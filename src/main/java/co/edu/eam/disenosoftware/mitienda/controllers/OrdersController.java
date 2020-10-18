package co.edu.eam.disenosoftware.mitienda.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
   * Get Order By Id API
   */
  @GetMapping("/{id}")
  public Order getOrderById(@PathVariable("id") Long id) {
    return orderService.getOrderByID(id);
  }

  /**
   * end order by id API
   */
  @PatchMapping("/{id}/end")
  public void endOrder(@PathVariable("id") Long id){
    orderService.finalizeOrder(id);
  }

}
