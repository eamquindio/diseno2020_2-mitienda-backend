package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.Store;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Stores Repository
 */
@Component
@Transactional
public class StoreRepository {

  /**
   * EntityManager
   */
  @PersistenceContext
  private EntityManager em;

  /**
   * Add a Store
   * @param store Store to create
   */
  public void create(Store store) {
    em.persist(store);
  }

  /**
   * Find a Store by primary key
   * @param id Primary key
   * @return a object Store or null if no exists
   */
  public Store find(Long id) {
    return em.find(Store.class, id);
  }

  /**
   * Edit a Store
   * @param store Store to edit
   */
  public void edit(Store store) {
    em.merge(store);
  }

  /**
   * Delete a Store finding it
   * @param id primary key
   * @return Store deleted or null if not exist
   */
  public Store delete(Long id) {
    Store store = find(id);
    if (store != null) {
      em.remove(store);
    }
    return store;
  }

  /**
   * A get all stores function
   *
   * @return , return all stores in data base
   */
  public List<Store> getAllStores() {
    String queryStr = "SELECT store FROM Store store";
    Query query = em.createQuery(queryStr);
    return query.getResultList();
  }
}
