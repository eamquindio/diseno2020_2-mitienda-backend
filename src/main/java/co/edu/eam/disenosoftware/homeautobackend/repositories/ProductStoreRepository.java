package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.ProductStore;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * product store Repository
 */
@Component
@Transactional
public class ProductStoreRepository {

  /**
   * EntityManager
   */
  @PersistenceContext
  private EntityManager em;

  /**
   *Find and return the products of the store that has the id sent
   * @param id , Foreign key
   * @return List of Products of the Store with the id that has been sent
   */
  public List<ProductStore> getProductsStoreByStoreId(Long id) {
    String queryStr = "SELECT ps FROM ProductStore ps WHERE ps.store.id = :id";
    Query query = em.createQuery(queryStr);
    query.setParameter("id", id);
    return query.getResultList();
  }

}
