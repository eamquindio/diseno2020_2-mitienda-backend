package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@SpringBootTest
public class PRoductRepositoryTest {

  @Autowired
  private ProductRepository repository;

  @PersistenceContext
  private EntityManager em;

  @BeforeEach
  public void setup() {
    em.createQuery("delete from Product");
  }

  @Test
  public void test() {
    Assertions.assertTrue(true);
  }

  @Test
  public void probeIfProductExistOrNot() {
    Product productA = new Product(1L, "url", "TLoU2");
    Product productB = new Product(2L, "url", "HALO");
    repository.create(productA);
    repository.create(productB);

    Product testProduct = repository.find(2L);

    Assertions.assertNotNull(testProduct);
    Assertions.assertEquals("HALO", testProduct.getName());

  }

  @Test
  public void probeIfProductIsDeletedOrNot() {
    repository.create(new Product(1L, "url", "TLoU2"));
    Product deletedProduct = repository.delete(1L);

    Assertions.assertNotNull(deletedProduct);
    Assertions.assertEquals("TLoU2", deletedProduct.getName());
    Product testProduct = em.find(Product.class, 1L);
    Assertions.assertNull(testProduct);


  }

  @Test
  public void deleteNullExistingProduct(){
    Product deletedProduct = repository.delete(1L);
    Assertions.assertNull(deletedProduct);
  }

  @Test
  public void findExistingProduct(){
    Product productA = new Product(1L, "url", "TLoU2");
    Product productB = new Product(2L, "url", "HALO");
    repository.create(productA);
    repository.create(productB);

    Product testProduct = repository.find(2L);

    Assertions.assertNotNull(testProduct);
    Assertions.assertEquals("HALO", testProduct.getName());

  }
  @Test
  public void findNullExistingProduct(){
    Product product = repository.find(1L);
    Assertions.assertNull(product);
  }

  @Test
  public void probeIfProductIsUpdatedOrNot(){
    Product productA = new Product(1L, "url", "TLoU2");
    repository.create(productA);

    productA.setName("HALO");
    repository.edit(productA);

    Product testProduct = repository.find(1L);

    Assertions.assertEquals("HALO",testProduct.getName());
  }

}
