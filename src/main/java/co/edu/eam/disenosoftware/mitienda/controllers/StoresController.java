package co.edu.eam.disenosoftware.mitienda.controllers;

import co.edu.eam.disenosoftware.mitienda.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
