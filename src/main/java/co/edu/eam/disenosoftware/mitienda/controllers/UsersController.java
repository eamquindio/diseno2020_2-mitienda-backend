package co.edu.eam.disenosoftware.mitienda.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import co.edu.eam.disenosoftware.mitienda.model.entities.User;
import co.edu.eam.disenosoftware.mitienda.model.requests.CreateUserRequest;
import co.edu.eam.disenosoftware.mitienda.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for orders entity
 */
@RestController
@RequestMapping("/api/users")
public class UsersController {

  @Autowired
  private UserService userService;

  /**
   * URL:/user
   * verbo:POST
   * parametros:{name,phone,username,email,password}
   */
  @PostMapping
  public void createUser(@RequestBody CreateUserRequest request){

    userService.createUser(request.getName(),request.getPhone(),request.getUsername(),request.getEmail(),request.getPassword());

  }

}
