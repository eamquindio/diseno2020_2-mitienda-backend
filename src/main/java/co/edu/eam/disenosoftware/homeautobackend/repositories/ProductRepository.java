package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.Product;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * product repository
 */
@Component
public class ProductRepository {
  /**
   * Adding persistence context
   */
  @PersistenceContext
  private EntityManager en;

  /**
   * product
   *
   * @param product , product
   */
  public void create(Product product) {
    en.persist(product);

  }

  /**
   * product
   *
   * @param id , product
   * @return , object
   */
  public Product find(Long id) {
    return en.find(Product.class, id);

  }

  /**
   * product
   *
   * @param product , product
   */
  public void edit(Product product) {
    en.merge(product);
  }

  /**
   * product
   *
   * @param id , id
   * @return , object
   */
  public Product delete(Long id) {
    Product product = find(id);
    en.remove(product);
    return product;
  }
}
