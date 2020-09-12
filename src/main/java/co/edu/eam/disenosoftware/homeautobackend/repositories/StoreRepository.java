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
