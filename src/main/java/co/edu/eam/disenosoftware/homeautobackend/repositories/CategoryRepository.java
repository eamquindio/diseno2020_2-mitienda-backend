package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.Category;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Category Repository
 */
@Component
@Transactional
public class CategoryRepository {

  /**
   * EntityManager
   */
  @PersistenceContext
  private EntityManager em;


  /**
   * Method to Find Id categories from Store
   * @param id Primary Key Category
   * @return List Of Category Store
   */
  public List<Category> getCategoryByStoreId(Long id) {

    String quertyStr = "SELECT category FROM Category category WHERE category.store.id = :id";

    Query query = em.createQuery(quertyStr);

    query.setParameter("id", id);

    return query.getResultList();
  }

}
