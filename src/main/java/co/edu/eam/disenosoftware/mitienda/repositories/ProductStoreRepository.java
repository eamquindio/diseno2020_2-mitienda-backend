package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
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
   *
   * @param productStore parametro para el create
   */
  public void create(ProductStore productStore) {
    em.persist(productStore);
  }

  /**
   * Find a ProductStore by primary key
   *
   * @param id parametro id del find
   * @return a ProductStore or null if not exists
   */
  public ProductStore find(Long id) {
    return em.find(ProductStore.class, id);
  }

  /**
   * Edit productStore
   *
   * @param productStore parametro para edit
   */
  public void edit(ProductStore productStore) {
    em.merge(productStore);
  }

  /**
   * Delete a productStore
   *
   * @param id parametro para delete
   * @return productStore deleted or null if not exists
   */
  public ProductStore delete(Long id) {

    ProductStore productStore = find(id);
    if (productStore != null) {
      em.remove(productStore);
    }
    return productStore;
  }

  /**
   * Find and return the products of the store that has the id sent
   *
   * @param id , Foreign key
   * @return List of Products of the Store with the id that has been sent
   */
  public List<ProductStore> getProductsStoreByStoreId(Long id) {
    String queryStr = "SELECT ps FROM ProductStore ps WHERE ps.store.id = :id";
    Query query = em.createQuery(queryStr);
    query.setParameter("id", id);
    return query.getResultList();

  }

  /**
   * Find an object productStore where this one match with productId and StoreId
   *
   * @param productId , productId
   * @param storeId   , storeId
   * @return , the object who match
   */
  public ProductStore getProductStoreByProductIdAndStoreId(Long productId, Long storeId) {
    String queryStr = "SELECT ps FROM ProductStore ps WHERE ps.id = :product_id AND ps.store.id = :store_id";

    Query query = em.createQuery(queryStr);
    query.setParameter("store_id", storeId);
    query.setParameter("product_id", productId);

    List<ProductStore> productStores = query.getResultList();

    return productStores.size() != 0 ? productStores.get(0) : null;
  }
  /**
   * find and get associated the productstore  with store
   *
   * @param idStore , Foreign key
   * @param idProduct , Foreign key
   * @return List of Products of the store that is associated
   */
  public ProductStore getProductStoreByIdStoreAndProductId(Long idStore, Long idProduct) {
    String queryStr = "SELECT ps FROM ProductStore ps WHERE ps.store.id = :idStore AND ps.product.id = :idProduct";
    Query query = em.createQuery(queryStr);
    query.setParameter("idStore", idStore);
    query.setParameter("idProduct", idProduct);
    List<ProductStore> queryResult = query.getResultList();

    return queryResult.size() != 0 ? queryResult.get(0) : null;
  }

}
