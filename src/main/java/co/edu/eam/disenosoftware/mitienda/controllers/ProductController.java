package co.edu.eam.disenosoftware.mitienda.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.Product;
import co.edu.eam.disenosoftware.mitienda.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for orders entity
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

  /**
   * Autowired
   */
  @Autowired
  private ProductService productService;

  /**
   * GetMapping
   *
   * @param name , name
   * @return , list product by name
   */
  @GetMapping("/by-name")
  public List<Product> listAllProductByName(@RequestParam("name_product") String name) {
    return productService.getAllProductByName(name);
  }
}
