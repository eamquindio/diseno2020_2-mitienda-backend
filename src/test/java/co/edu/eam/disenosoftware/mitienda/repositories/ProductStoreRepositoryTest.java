package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.model.entities.Category;
import co.edu.eam.disenosoftware.mitienda.model.entities.Product;
import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
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
  public void getProductsStoreByStoreId() {
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
    List<ProductStore> productStores = repository.getProductsStoreByStoreId(1L);

    //Test Verification
    Assertions.assertEquals(3, productStores.size());
  }

  /**
   * Test createNoExistingProductStoreTest
   */
  @Test
  public void createNoExistingProductStoreTest(){
    Product product = new Product(111L);
    em.persist(product);
    Store store = new Store(115L);
    em.persist(store);
    Category category = new Category(113L);
    em.persist(category);


    ProductStore productStore = new ProductStore(1L, product, 12, 1200, category, store);
    em.persist(productStore);
    repository.create(productStore);

    ProductStore productStoreToAssert = repository.find(1L);

    Assertions.assertNotNull(productStoreToAssert);
    Assertions.assertEquals(1L, productStoreToAssert.getId());
    Assertions.assertEquals(111L, productStoreToAssert.getProduct().getId());
    Assertions.assertEquals(115L, productStoreToAssert.getStore().getId());
    Assertions.assertEquals(113L, productStoreToAssert.getCategory().getId());
  }

  /**
   * Test findExistingProductStoreTest
   */
  @Test
  public void findExistingProductStoreTest(){
    Product product = new Product(111L);
    em.persist(product);
    Store store = new Store(115L);
    em.persist(store);
    Category category = new Category(113L);
    em.persist(category);

    ProductStore productStore = new ProductStore(1L, product, 12, 1200, category, store);
    em.persist(productStore);

    ProductStore productStoreToAssert = repository.find(1L);
    Assertions.assertNotNull(productStoreToAssert);
    Assertions.assertEquals(1L, productStoreToAssert.getId());
    Assertions.assertEquals(productStore, productStoreToAssert);
  }


  /**
   * Test findNotExistingProductStoreTest
   */
  @Test
  public void findNotExistingProductStoreTest(){
    ProductStore productStoreToAssert = repository.find(1L);
    Assertions.assertNull(productStoreToAssert);
  }

  /**
   * Test updateExistingProductStoreTest
   */
  @Test
  public void updateExistingProductStoreTest(){
    Product product = new Product(111L);
    em.persist(product);
    Store store = new Store(115L);
    em.persist(store);
    Category category = new Category(113L);
    em.persist(category);

    ProductStore productStore = new ProductStore(1L, product, 12, 1200, category, store);
    em.persist(productStore);

    productStore.setPrice(2000);
    repository.edit(productStore);

    ProductStore productStoreToAssert = repository.find(1L);

    Assertions.assertNotNull(productStoreToAssert);
    Assertions.assertEquals(2000, productStoreToAssert.getPrice());
  }

  /**
   * Test deleteExistingProductStoreTest
   */
  @Test
  public void deleteExistingProductStoreTest(){
    Product product = new Product(111L);
    Store store = new Store(115L);
    Category category = new Category(113L);


    ProductStore productStore = new ProductStore(1L, product, 12, 1200, category, store);
    repository.create(productStore);

    ProductStore deletedProductStore = repository.delete(1L);

    ProductStore productStoreToAssert = repository.find(1L);

    Assertions.assertNull(productStoreToAssert);
    Assertions.assertNotNull(deletedProductStore);
    Assertions.assertEquals(productStore, deletedProductStore);
  }
}



