package co.edu.eam.disenosoftware.mitienda.repositories;


import co.edu.eam.disenosoftware.mitienda.model.entities.ShoppingCart;
import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.model.entities.User;
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
  public void createNoExistingShoppingCartTest(){

    User user=new User(20L);
    Store store=new Store(30L);

    ShoppingCart shoppingCart= new ShoppingCart(1L,store,user);
    repository.create(shoppingCart);

    ShoppingCart shoppingCartToAssert= repository.find(1L);

    Assertions.assertNotNull(shoppingCartToAssert);
    Assertions.assertEquals(1L,shoppingCartToAssert.getId());
    Assertions.assertEquals(20L,user.getId());


  }


  @Test
  public void deleteExistingShoppingCartTest(){

    User user=new User(20L);
    Store store=new Store(30L);

    ShoppingCart shoppingCart= new ShoppingCart(1L,store,user);

    repository.create(shoppingCart);

    ShoppingCart deleteShoppingCart=repository.delete(1L);

    Assertions.assertNotNull(deleteShoppingCart);
    Assertions.assertNotNull(shoppingCart);
    Assertions.assertEquals(shoppingCart,deleteShoppingCart);

  }

  @Test
  public void deleteNotExistingShoppingCartTest(){

    ShoppingCart shoppingCartDelete=repository.delete(1L);

    Assertions.assertNull(shoppingCartDelete);

  }

  @Test
  public void findExistingShoppingTest(){

    User user=new User(20L);
    Store store=new Store(30L);

    ShoppingCart shoppingCart= new ShoppingCart(1L,store,user);

    em.persist(shoppingCart);

    ShoppingCart shoppingCartToAssert=repository.find(1L);

    Assertions.assertNotNull(shoppingCartToAssert);
    Assertions.assertEquals(1L, shoppingCartToAssert.getId());
    Assertions.assertEquals(shoppingCart, shoppingCartToAssert);

  }

  @Test
  public void findNotExistingShoppingCartTest() {

    ShoppingCart shoppingCartToAssert = repository.find(1L);

    Assertions.assertNull(shoppingCartToAssert);

  }

  @Test
  public void updateExistingShoppingCartTest() {

    User user = new User(20L);
    Store store = new Store(30L);
    User user2=new User(22L);

    em.persist(store);
    em.persist(user);
    em.persist(user2);

    ShoppingCart shoppingCart= new ShoppingCart(1L,store,user);
    em.persist(shoppingCart);

    shoppingCart.setUser(user2);
    repository.edit(shoppingCart);

    ShoppingCart shoppingCartToAssert = repository.find(1L);
    Assertions.assertNotNull(shoppingCartToAssert);
    Assertions.assertEquals(22L, shoppingCartToAssert.getUser().getId());
  }

}
