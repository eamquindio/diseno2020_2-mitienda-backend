package co.edu.eam.disenosoftware.mitienda.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for stores entity
 */
@RestController
@RequestMapping(Routes.STORES_PATH)
public class StoresController {

  /**
   * Store repository
   */
  @Autowired
  private StoreRepository storeRepository;

  /**
   * Get all stores
   *
   * @return return all stores
   */
  @GetMapping(path = "/")
  public List<Store> getStores() {
    return storeRepository.getAllStores();
  }
}
