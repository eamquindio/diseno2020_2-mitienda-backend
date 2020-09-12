package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.ProductStore;
import co.edu.eam.disenosoftware.homeautobackend.model.entities.ShoppingCart;
import co.edu.eam.disenosoftware.homeautobackend.model.entities.ShoppingCartProduct;
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
public class ShoppingCartProductRepositoryTest {

  @Autowired
  private ShoppingCartProductRepository repository;

  @PersistenceContext
  private EntityManager em;

  @BeforeEach
  public void setup() {
    em.createQuery("delete from ShoppingCartProduct");
  }

  @Test
  public void test() {
    Assertions.assertTrue(true);
  }

  /**
   * Create Method Test with a non existing shopping cart product
   */
  @Test
  public void createNotExistingShoppingCartProductTest() {
    //Preparing Test
    ShoppingCart shoppingCart = new ShoppingCart(20L);
    ProductStore productStore = new ProductStore(58L);
    em.persist(shoppingCart);
    em.persist(productStore);

    ShoppingCartProduct shoppingCartProduct = new ShoppingCartProduct(1L, shoppingCart, productStore, 10);

    //Testing Code
    repository.create(shoppingCartProduct);

    //Test Verification
    ShoppingCartProduct shoppingCartProductToAssert = repository.find(1L);

    Assertions.assertNotNull(shoppingCartProductToAssert);
    Assertions.assertEquals(1L, shoppingCartProductToAssert.getId());
    Assertions.assertEquals(58L, shoppingCartProductToAssert.getProduct().getId());
    Assertions.assertEquals(20L, shoppingCartProductToAssert.getShoppingCart().getId());
  }

  /**
   * Delete Method Test with an existing shopping cart product
   */
  @Test
  public void deleteExistingShoppingCartProductTest() {
    //Preparing Test
    ShoppingCart shoppingCart = new ShoppingCart();
    ProductStore productStore = new ProductStore();

    ShoppingCartProduct shoppingCartProduct = new ShoppingCartProduct(1L, shoppingCart, productStore, 10);

    repository.create(shoppingCartProduct);

    //Testing Code
    ShoppingCartProduct deletedShoppingCartProduct = repository.delete(1L);


    //Test Verification
    ShoppingCartProduct shoppingCartProductToAssert = repository.find(1L);

    Assertions.assertNull(shoppingCartProductToAssert);
    Assertions.assertNotNull(deletedShoppingCartProduct);
    Assertions.assertEquals(shoppingCartProduct, deletedShoppingCartProduct);
  }

  /**
   * Delete Method Test with a non existing shopping cart product
   */
  @Test
  public void deleteNotExistingShoppingCartProductTest() {
    //Testing Code
    ShoppingCartProduct deletedShoppingCartProduct = repository.delete(1L);

    //Test Verification
    Assertions.assertNull(deletedShoppingCartProduct);
  }

  /**
   * Find Method Test with an existing shopping cart product
   */
  @Test
  public void findExistingShoppingCartProductTest() {
    //Preparing Test
    ShoppingCart shoppingCart = new ShoppingCart(20L);
    ProductStore productStore = new ProductStore(58L);
    em.persist(shoppingCart);
    em.persist(productStore);

    ShoppingCartProduct shoppingCartProduct = new ShoppingCartProduct(1L, shoppingCart, productStore, 10);

    em.persist(shoppingCartProduct);

    //Testing Code
    ShoppingCartProduct shoppingCartProductToAssert = repository.find(1L);

    //Test Verification
    Assertions.assertNotNull(shoppingCartProductToAssert);
    Assertions.assertEquals(1L, shoppingCartProductToAssert.getId());
    Assertions.assertEquals(shoppingCartProduct, shoppingCartProductToAssert);
  }
  /**
   * find Method Test with a non existing shopping cart product
   */
  @Test
  public void findNotExistingShoppingCartProductTest() {
    //Testing Code
    ShoppingCartProduct shoppingCartProductToAssert = repository.find(1L);

    //Test Verification
    Assertions.assertNull(shoppingCartProductToAssert);
  }

  /**
   * Edit Method Test with an existing shopping cart product
   */
  @Test
  public void updateExistingShoppingCartProductTest() {
    //Preparing Test
    ShoppingCart shoppingCart = new ShoppingCart(20L);
    ProductStore productStore = new ProductStore(58L);
    em.persist(shoppingCart);
    em.persist(productStore);

    ShoppingCartProduct shoppingCartProduct = new ShoppingCartProduct(1L, shoppingCart, productStore, 10);

    em.persist(shoppingCartProduct);

    //Testing Code
    shoppingCartProduct.setQuantity(20);
    repository.edit(shoppingCartProduct);

    //Test Verification
    ShoppingCartProduct shoppingCartProductToAssert = repository.find(1L);

    Assertions.assertNotNull(shoppingCartProductToAssert);
    Assertions.assertEquals(20, shoppingCartProductToAssert.getQuantity());
  }

}
