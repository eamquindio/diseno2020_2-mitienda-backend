package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.model.entities.Category;
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
   * Create a category
   *
   * @param category category to Create.
   */
  public void create(Category category) {
    em.persist(category);
  }

  /**
   * Find a category by primary key
   *
   * @param id primary key
   * @return a order or null if not exists
   */
  public Category find(Long id) {
    return em.find(Category.class, id);
  }

  /**
   * Method to Find Id categories from Store
   *
   * @param id Primary Key Category
   * @return List Of Category Store
   */
  public List<Category> getCategoryByStoreId(Long id) {

    String quertyStr = "select c from Category c where c.store.id = :id";

    Query query = em.createQuery(quertyStr);

    query.setParameter("id", id);
    return query.getResultList();
  }

  /**
   * Method to Find Id and name categories from Store
   *
   * @param id Primary Key Category
   * @param name secundary key category
   * @return Category result
   */
  public Category getCategoryByStoreIdAndName(Long id, String name) {

    String queryStr = "SELECT category FROM Category category WHERE category.store.id = :id AND category.name = :name";

    Query query = em.createQuery(queryStr);

    query.setParameter("id", id);
    query.setParameter("name", name);

    List<Category> list = query.getResultList();

    return list.size() != 0 ? list.get(0) : null;
  }

}
