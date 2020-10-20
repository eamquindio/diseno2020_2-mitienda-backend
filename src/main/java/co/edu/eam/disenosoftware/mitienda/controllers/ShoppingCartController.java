package co.edu.eam.disenosoftware.mitienda.controllers;


import co.edu.eam.disenosoftware.mitienda.model.requests.AddShoppingCartProductRequest;
import co.edu.eam.disenosoftware.mitienda.services.ShoppingCartProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Controller for orders entity
 */
@RestController
@RequestMapping("/api/shopping-cart")
public class ShoppingCartController {

  /**
   * autowired
   */
  //ESTE ES EL QUE BUSCAS AMOR
  @Autowired
  private ShoppingCartProductService shoppingCartProductService;

  /**
   * function to create a product into shopping cart
   * @param scp , request object for service call
   */
  @PostMapping("/add-product")
  public void addProductToShoppingCartRequest(@RequestBody @Valid AddShoppingCartProductRequest scp) {
    shoppingCartProductService.createShoppingCartProduct(scp.getStoreId(), scp.getProductId(), scp.getUserId(),
            scp.getQuantity());
  }

}
