package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.Product;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


/**
 * Product Repository
 */
@Component
@Transactional
public class ProductRepository {

  /**
   * EntityManager
   */
  @PersistenceContext
  private EntityManager em;

  /**
   * Product's create function
   *
   * @param product , a product's object
   */
  public void create(Product product) {
    em.persist(product);
  }

  /**
   * Product's find function
   *
   * @param id , The store's primary key
   * @return , return a Store or null
   */
  public Product find(Long id) {
    return em.find(Product.class, id);
  }

  /**
   * Product's edit function
   *
   * @param product , an object product
   */
  public void edit(Product product) {
    em.merge(product);
  }

  /**
   * Product's delete function
   *
   * @param id , delete a store by id
   * @return , return a product deleted already
   */
  public Product delete(Long id) {
    Product product = find(id);
    if (product != null) {
      em.remove(product);
    }
    return product;
  }

  /**
   *search products by name
   * @param name product name is requested
   * @return list of similar product names
   */
  public List<Product> getProductsName(String name) {
    String queryStr = " SELECT n FROM Room n WHERE LOWER(n.name) LIKE LOWER(:name)";
    Query query = em.createQuery(queryStr);
    query.setParameter("name", "%" + name + "%");
    return query.getResultList();
  }
}
