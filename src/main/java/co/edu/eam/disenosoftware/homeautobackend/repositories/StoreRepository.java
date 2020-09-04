package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.Store;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * store repository
 */
@Component
public class StoreRepository {
  /**
   * Adding persistence context
   */
  @PersistenceContext
  private EntityManager en;

  /**
   * store
   * @param store , store
   */
  public void create(Store store) {
    en.persist(store);
  }

  /**
   * store
   * @param id , id
   * @return , object
   */
  public Store find(Long id) {
    return en.find(Store.class, id);

  }

  /**
   * store
   * @param store , store
   */
  public void edit(Store store) {
    en.merge(store);
  }

  /**
   * store
   * @param id , id
   * @return , object
   */
  public Store delete(Long id) {
    Store store = find(id);
    en.remove(store);
    return store;
  }
}
