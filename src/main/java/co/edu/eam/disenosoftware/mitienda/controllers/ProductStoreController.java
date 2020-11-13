package co.edu.eam.disenosoftware.mitienda.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
import co.edu.eam.disenosoftware.mitienda.services.ProductStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for orders entity
 */
@RestController
@RequestMapping("/api/products-store")
public class ProductStoreController {

  /**
   * AUtowired
   */
  @Autowired
  private ProductStoreService productStoreService;

  /**
   * get all product store by the store id
   * @param storeId , stores id
   * @return , list of product in store
   */
  @GetMapping("/stores/{storeId}/products")
  public List<ProductStore> getAllProductStoreByStoreId(@PathVariable Long storeId) {
    return productStoreService.getAllProductStoreByStoreId(storeId);
  }

  /**
   * Get Product Store By Product Store Id
   * @param productId , Product Store Id
   * @return , The product Store Finded
   */
  @GetMapping("/{productId}")
  public ProductStore getProductStoreById(@PathVariable Long productId) {
    return productStoreService.getProductStoreById(productId);
  }

}
