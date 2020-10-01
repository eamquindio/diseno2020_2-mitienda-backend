package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
import co.edu.eam.disenosoftware.mitienda.model.entities.ShoppingCart;
import co.edu.eam.disenosoftware.mitienda.model.entities.ShoppingCartProduct;
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
  @Sql({"/testdata/create_not_existing_shopping_cart_product.sql"})
  public void createNotExistingShoppingCartProductTest() {
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
  @Sql({"/testdata/delete_existing_shopping_cart_product.sql"})
  public void deleteExistingShoppingCartProductTest() {
    ShoppingCartProduct shoppingCartProduct = repository.find(1L);
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
  @Sql({"/testdata/find_existing_shopping_cart_product.sql"})
  public void findExistingShoppingCartProductTest() {
    //Testing Code
    ShoppingCartProduct shoppingCartProductToAssert = repository.find(1L);

    //Test Verification
    Assertions.assertNotNull(shoppingCartProductToAssert);
    Assertions.assertEquals(1L, shoppingCartProductToAssert.getId());
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
  @Sql({"/testdata/update_existing_shopping_cart_product.sql"})
  public void updateExistingShoppingCartProductTest() {
    //Preparing Test
    ShoppingCartProduct shoppingCartProduct = repository.find(1L);

    //Testing Code
    shoppingCartProduct.setQuantity(20);
    repository.edit(shoppingCartProduct);

    //Test Verification
    ShoppingCartProduct shoppingCartProductToAssert = repository.find(1L);

    Assertions.assertNotNull(shoppingCartProductToAssert);
    Assertions.assertEquals(20, shoppingCartProductToAssert.getQuantity());
  }

  @Test
  @Sql({"/testdata/get_shopping_cart_products_by_shopping_cart_id.sql"})
  public void getShoppingCartProductsByShoppingCartIdTest(){
    List<ShoppingCartProduct> shoppingCartProductToAssert = repository.getShoppingCartProductsByShoppingCartId(1L);
    Assertions.assertEquals(3, shoppingCartProductToAssert.size());
  }
}
