package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.Category;
import co.edu.eam.disenosoftware.homeautobackend.model.entities.Product;
import co.edu.eam.disenosoftware.homeautobackend.model.entities.ProductStore;
import co.edu.eam.disenosoftware.homeautobackend.model.entities.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@SpringBootTest
public class ProductStoreRepositoryTest {

  @Autowired
  private ProductStoreRepository repository;

  @PersistenceContext
  private EntityManager em;

  @BeforeEach
  public void setup() {
    em.createQuery("delete from ProductStore");
  }

  @Test
  public void test() {
    Assertions.assertTrue(true);
  }

  /**
   * Method getAllProductsOfStoreTest Test
   */
  @Test
  public void getAllProductsOfStoreTest() {
    //Preparing Test
    Store store = new Store(1L);
    Store store1 = new Store(2L);
    em.persist(store);
    em.persist(store1);

    Product product = new Product(1L);
    Product product1 = new Product(2L);
    Product product2 = new Product(3L);
    em.persist(product);
    em.persist(product1);
    em.persist(product2);

    Category category = new Category(1L);
    Category category1 = new Category(2L);
    em.persist(category);
    em.persist(category1);

    ProductStore productStore = new ProductStore(1L, product, 10, 20000, category,store);
    ProductStore productStore1 = new ProductStore(2L, product, 10, 20000, category1,store1);
    ProductStore productStore2 = new ProductStore(3L, product1, 10, 20000, category,store);
    ProductStore productStore3 = new ProductStore(4L, product2, 10, 20000, category1,store);
    ProductStore productStore4 = new ProductStore(5L, product2, 10, 20000, category,store1);
    em.persist(productStore);
    em.persist(productStore1);
    em.persist(productStore2);
    em.persist(productStore3);
    em.persist(productStore4);

    //Testing Code
    List<ProductStore> productStores = repository.getAllProductsOfStore(1L);

    //Test Verification
    Assertions.assertEquals(3, productStores.size());
  }

}
