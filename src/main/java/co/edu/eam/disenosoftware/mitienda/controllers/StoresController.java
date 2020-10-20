package co.edu.eam.disenosoftware.mitienda.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
   * URL: /is_open
   * Verbo: Get
   * Retorno: Número n de tiendas
   * @return list of stores
   */
  @GetMapping("/is-open")
  public List<Store> getAllStoresOpen() {
    return storeService.getOpenStores();
  }
}
