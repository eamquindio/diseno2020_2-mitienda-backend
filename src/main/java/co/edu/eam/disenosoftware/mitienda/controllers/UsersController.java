package co.edu.eam.disenosoftware.mitienda.controllers;

import co.edu.eam.disenosoftware.mitienda.model.requests.UserLoginRequest;
import co.edu.eam.disenosoftware.mitienda.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.services.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import co.edu.eam.disenosoftware.mitienda.model.entities.User;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.List;

/**
 * Controller for orders entity
 */
@RestController
@RequestMapping("/api/users")
public class UsersController {

  /**
   * Autowired
   * User service
   */
  @Autowired
  private UserService userService;

  /**
   *  Order Service
   */
  @Autowired
  private OrderService orderService;

  /**
   * URL:/api/users
   * verbo:POST
   * parametros:{ name,phone,username,email,password }
   * @param request , User user
   */
  @PostMapping("/register")
  public void createUser(@RequestBody User request) {
    userService.createUser(request.getName(), request.getPhone(),
            request.getUsername(), request.getEmail(),
            request.getPassword());
  }

  /**
   * Login from user
   * @param request request user login
   * @return returns boolean when successfully logged in
   */
  @PostMapping("/login")
  public User userLogin(@RequestBody @Valid UserLoginRequest request) {
    return userService.userLogin(request.getUsername(), request.getPassword());
  }

  /**
   *  API orders by user ID
   * @param userId , id of user
   * @return a list of orders
   */
  @GetMapping("/{user_id}/orders")
  public List<Order> ordersByUserId(@PathVariable("user_id")Long userId) {
    return orderService.getOrdersByUserId(userId);
  }
}
