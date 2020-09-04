package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.ProductStore;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * product store repository
 */
@Component
public class ProductStoreRepository {
  /**
   * Adding persistence context
   */
  @PersistenceContext
  private EntityManager en;

  /**
   * product store
   * @param productStore , product store
   */
  public void create(ProductStore productStore) {
    en.persist(productStore);
  }

  /**
   * product store
   * @param id , id
   * @return , object
   */
  public ProductStore find(Long id) {
    return en.find(ProductStore.class, id);

  }

  /**
   * product store
   * @param productStore , product store
   */

  public void edit(ProductStore productStore) {
    en.merge(productStore);
  }

  /**
   * product store
   * @param id , id
   * @return , object
   */
  public ProductStore delete(Long id) {
    ProductStore productStore = find(id);
    en.remove(productStore);
    return productStore;
  }
}
