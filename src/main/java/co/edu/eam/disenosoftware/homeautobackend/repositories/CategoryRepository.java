package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.Category;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Categories repository
 */
@Component
public class CategoryRepository {
  /**
   * Adding persistence context
   */
  @PersistenceContext
  private EntityManager en;

  /**
   * categories
   * @param category , category
   */
  public void create(Category category) {
    en.persist(category);
  }


  /**
   * categories
   * @param id , id
   * @return , object
   */
  public Category find(Long id) {
    return en.find(Category.class, id);

  }

  /**
   * categories create
   * @param category , category
   */
  public void edit(Category category) {

    en.merge(category);
  }

  /**
   * categories
   * @param id , id
   * @return , object
   */
  public Category delete(Long id) {
    Category category = find(id);
    en.remove(category);
    return category;
  }
}
