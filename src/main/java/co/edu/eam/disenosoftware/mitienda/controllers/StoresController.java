package co.edu.eam.disenosoftware.mitienda.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.Category;
import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.services.CategoryService;
import co.edu.eam.disenosoftware.mitienda.services.OrderService;
import co.edu.eam.disenosoftware.mitienda.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for stores entity
 */
@RestController
@RequestMapping("/api/stores")
public class StoresController {

  /**
   * Store service
   */
  @Autowired
  private StoreService storeService;

  /**
   *  Order Service
   */
  @Autowired
  private OrderService orderService;

  /**
   * URL: /is_open
   * Verbo: Get
   * Retorno: Número n de tiendas
   * @return list of stores
   */
  @GetMapping("/is-open")
  public List<Store> getAllStoresOpen() {
    return storeService.getOpenStores();
  }

  /**
   * API orders by store ID
   *
   * @param storeId , id of store
   * @return a list of orders
   */
  @GetMapping("/{store_id}/orders")
  public List<Order> ordersByStoreId(@PathVariable("store_id") Long storeId) {
    return orderService.getOrdersByStoreId(storeId);
  }

  /**
   * Autowired
   */
  @Autowired
  private CategoryService categoryService;

  /**
   * GetMapping
   *
   * @param id , id
   * @return , list Category by store id
   */
  @GetMapping("/stores/{storeId}/categories")
  public List<Category> listAllCategoryByStoreId(@PathVariable Long id) {
    return categoryService.getAllCategoryByStoreId(id);
  }
}
