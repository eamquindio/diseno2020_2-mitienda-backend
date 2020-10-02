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
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@SpringBootTest
public class ProductStoreRepositoryTest {

  @Autowired
  private ProductStoreRepository repository;

  @Autowired
  private ProductRepository repositoryProduct;

  @Autowired
  private StoreRepository repositoryStore;

  @Autowired
  private CategoryRepository categoryRepository;

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
  @Sql({"/testdata/get_products_store_by_store_id.sql"})
  public void getProductsStoreByStoreId() {
    List<ProductStore> productStores = repository.getProductsStoreByStoreId(3L);
    Assertions.assertEquals(2, productStores.size());
  }

  /**
   * Test createNoExistingProductStoreTest
   */
  @Test
  @Sql({"/testdata/create_no_existing_product_store.sql"})
  public void createNoExistingProductStoreTest(){
    Product product = repositoryProduct.find(2L);
    Store store = repositoryStore.find(3L);
    Category category = categoryRepository.find(10L);
    ProductStore productStore = new ProductStore(product, 10, 1000, category, store);
    repository.create(productStore);
    List<ProductStore> productStores= em.createQuery("SELECT productStore FROM ProductStore productStore ").getResultList();
    Assertions.assertNotEquals(0, productStores.size());
  }

  /**
   * Test findExistingProductStoreTest
   */
  @Test
  @Sql({"/testdata/find_existing_product_store.sql"})
  public void findExistingProductStoreTest(){
    ProductStore productStoreToAssert = repository.find(6L);
    Assertions.assertNotNull(productStoreToAssert);
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
  @Sql({"/testdata/update_existing_product_store.sql"})
  public void updateExistingProductStoreTest(){
    ProductStore productStore = repository.find(6L);
    productStore.setPrice(2000);
    repository.edit(productStore);
    ProductStore productStoreToAssert = repository.find(6L);
    Assertions.assertNotNull(productStoreToAssert);
    Assertions.assertEquals(2000, productStoreToAssert.getPrice());
  }

  /**
   * Test deleteExistingProductStoreTest
   */
  @Test
  @Sql({"/testdata/delete_existing_product_store.sql"})
  public void deleteExistingProductStoreTest(){
    ProductStore deletedProductStore = repository.delete(6L);
    Assertions.assertNotNull(deletedProductStore);
  }
}



