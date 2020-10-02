package co.edu.eam.disenosoftware.mitienda.repositories;


import co.edu.eam.disenosoftware.mitienda.model.entities.ShoppingCart;
import co.edu.eam.disenosoftware.mitienda.model.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Transactional
@SpringBootTest
public class ShoppingCartRepositoryTest {

  @Autowired
  private ShoppingCartRepository repository;

  @PersistenceContext
  private EntityManager em;

  @BeforeEach
  public void setup() {
    em.createQuery("delete from ShoppingCart");
  }

  @Test
  public void test() {
    Assertions.assertTrue(true);
  }

  @Test
  @Sql({"/testdata/create_not_existing_shopping_cart.sql"})
  public void createNoExistingShoppingCartTest(){
    ShoppingCart shoppingCartToAssert= repository.find(1L);

    Assertions.assertNotNull(shoppingCartToAssert);
    Assertions.assertEquals(1L,shoppingCartToAssert.getId());
    Assertions.assertEquals(20L,shoppingCartToAssert.getUser().getId());
  }

  @Test
  @Sql({"/testdata/delete_existing_shopping_cart.sql"})
  public void deleteExistingShoppingCartTest(){
    ShoppingCart shoppingCartToAssert =repository.find(1L);
    ShoppingCart deleteShoppingCart=repository.delete(1L);
    Assertions.assertNotNull(deleteShoppingCart);
    Assertions.assertNotNull(shoppingCartToAssert);
    Assertions.assertEquals(shoppingCartToAssert,deleteShoppingCart);
  }

  @Test
  public void deleteNotExistingShoppingCartTest(){
    ShoppingCart shoppingCartDelete=repository.delete(1L);

    Assertions.assertNull(shoppingCartDelete);
  }

  @Test
  @Sql({"/testdata/find_existing_shopping_cart.sql"})
  public void findExistingShoppingTest(){
    ShoppingCart shoppingCartToAssert=repository.find(1L);

    Assertions.assertNotNull(shoppingCartToAssert);
    Assertions.assertEquals(1L, shoppingCartToAssert.getId());
  }

  @Test
  public void findNotExistingShoppingCartTest() {

    ShoppingCart shoppingCartToAssert = repository.find(1L);

    Assertions.assertNull(shoppingCartToAssert);
  }

  @Test
  @Sql({"/testdata/update_existing_shopping_cart.sql"})
  public void updateExistingShoppingCartTest() {
    ShoppingCart shoppingCart= repository.find(1L);
    shoppingCart.setUser(em.find(User.class, 22L));
    repository.edit(shoppingCart);

    ShoppingCart shoppingCartToAssert = repository.find(1L);
    Assertions.assertNotNull(shoppingCartToAssert);
    Assertions.assertEquals(22L, shoppingCartToAssert.getUser().getId());
  }
}
