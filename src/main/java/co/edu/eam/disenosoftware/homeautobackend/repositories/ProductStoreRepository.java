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
   * Create a productStore
   * @param productStore parametro para el create
   */
  public void create(ProductStore productStore) {
    em.persist(productStore);
  }

  /**
   * Find a ProductStore by primary key
   * @param id parametro id del find
   * @return a ProductStore or null if not exists
   */
  public ProductStore find(Long id) {
    return em.find(ProductStore.class, id);
  }

  /**
   * Edit productStore
   * @param productStore parametro para edit
   */
  public void edit(ProductStore productStore) {
    em.merge(productStore);
  }

  /**
   * Delete a productStore
   * @param id parametro para delete
   * @return productStore deleted or null if not exists
   */
  public ProductStore delete(Long id) {

    ProductStore productStore = find(id);
    em.remove(productStore);
    return productStore;
  }

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
