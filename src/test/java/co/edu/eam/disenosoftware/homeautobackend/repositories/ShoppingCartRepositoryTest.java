package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.Store;
import co.edu.eam.disenosoftware.homeautobackend.model.entities.User;
import co.edu.eam.disenosoftware.homeautobackend.model.entities.Product;
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
import java.util.ArrayList;
import java.util.List;

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
  public void getAlShoppingCartByUserIdAndStoreId() {

    User user = new User(1L, "pedro");
    em.persist(user);

    Store store = new Store(1L);
    em.persist(store);

    ShoppingCart shoppingCart = new ShoppingCart(1L, store, user);
    em.persist(shoppingCart);

    List<ShoppingCart> shoppingCartList = repository.getAlShoppingCartByUserIdAndStoreId(1L, 1L);
    Assertions.assertEquals(1, shoppingCartList.size());
  }
  @Test
  public void createNoExistingShoppingCartTest(){

    User user=new User(20L);
    Store store=new Store(30L);
    List<ShoppingCartProduct> shoppingCartProductList=new ArrayList<>();




    ShoppingCart shoppingCart= new ShoppingCart(1L,store,shoppingCartProductList,user);
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
    List<ShoppingCartProduct> shoppingCartProductList=new ArrayList<>();

    ShoppingCart shoppingCart= new ShoppingCart(1L,store,shoppingCartProductList,user);

    repository.create(shoppingCart);


    ShoppingCart deleteShoppingCart=repository.delete(1L);

    Assertions.assertNotNull(deleteShoppingCart);
    Assertions.assertNotNull(shoppingCart);
    Assertions.assertEquals(shoppingCart,deleteShoppingCart);


  }

  @Test
  public void deleteNotExistingShoppingCartTest(){

    ShoppingCart shoppingCartDelete=repository.delete(1L);

    Assertions.assertNotNull(shoppingCartDelete);

  }

  @Test
  public void findExistingShoppingTest(){

    User user=new User(20L);
    Store store=new Store(30L);
    List<ShoppingCartProduct> shoppingCartProductList=new ArrayList<>();

    ShoppingCart shoppingCart= new ShoppingCart(1L,store,shoppingCartProductList,user);

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
    //Preparing Test


    User user=new User(20L);
    Store store=new Store(30L);
    List<ShoppingCartProduct> shoppingCartProductList=new ArrayList<>();



    em.persist(store);
    em.persist(user);

    ShoppingCart shoppingCart= new ShoppingCart(1L,store,shoppingCartProductList,user);
    em.persist(shoppingCart);


    shoppingCart.setId(2L);
    repository.edit(shoppingCart);

    ShoppingCart shoppingCartToAssert = repository.find(2L);

    Assertions.assertNotNull(shoppingCartToAssert);
    Assertions.assertEquals(2L, shoppingCartToAssert.getId());
  }

}
