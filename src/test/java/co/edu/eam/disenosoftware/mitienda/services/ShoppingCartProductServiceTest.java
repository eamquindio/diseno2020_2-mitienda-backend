package co.edu.eam.disenosoftware.mitienda.services;

import co.edu.eam.disenosoftware.mitienda.exceptions.BusinessException;
import co.edu.eam.disenosoftware.mitienda.exceptions.ErrorCodesEnum;
import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
import co.edu.eam.disenosoftware.mitienda.model.entities.ShoppingCart;
import co.edu.eam.disenosoftware.mitienda.model.entities.ShoppingCartProduct;
import co.edu.eam.disenosoftware.mitienda.repositories.ShoppingCartProductRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.ShoppingCartRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import co.edu.eam.disenosoftware.mitienda.model.entities.Category;
import co.edu.eam.disenosoftware.mitienda.model.entities.Product;
import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.model.entities.User;
import co.edu.eam.disenosoftware.mitienda.repositories.ProductStoreRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.StoreRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Transactional
@SpringBootTest
public class ShoppingCartProductServiceTest {

  @PersistenceContext
  private EntityManager em;

  @Autowired
  private ShoppingCartProductService shoppingCartProductService;

  @Autowired
  private ShoppingCartRepository shoppingCartRepository;

  @Autowired
  private ShoppingCartProductRepository shoppingCartProductRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private StoreRepository storeRepository;

  @Autowired
  private ProductStoreRepository productStoreRepository;



  @Test
  @Sql({"/testdata/remove_product_from_shopping_cart.sql"})
  public void removeProductFromShoppingCartTest() {
    shoppingCartProductService.removeProductFromShoppingCart(1L,1L);

    ShoppingCartProduct shoppingCartProductToAssert = shoppingCartProductRepository.find(1L);
    Assertions.assertNull(shoppingCartProductToAssert);

    ShoppingCart shoppingCartToAssert = shoppingCartRepository.find(1L);
    Assertions.assertNotNull(shoppingCartToAssert);
    Assertions.assertEquals(1900,shoppingCartToAssert.getTotalValue());
  }

  @Test
  @Sql({"/testdata/last_shopping_cart_product.sql"})
  public void lastShoppingCartProductTest(){
    shoppingCartProductService.removeProductFromShoppingCart(1L,1L);

    ShoppingCartProduct shoppingCartProductToAssert = shoppingCartProductRepository.find(1L);
    Assertions.assertNull(shoppingCartProductToAssert);

    ShoppingCart shoppingCartToAssert = shoppingCartRepository.find(1L);
    Assertions.assertNull(shoppingCartToAssert);
  }

  @Test
  @Sql({"/testdata/shopping_cart_product_is_not_existing.sql"})
  public void shoppingCartProductIsNotExisting(){
    BusinessException exception = Assertions.assertThrows(BusinessException.class, () -> shoppingCartProductService.removeProductFromShoppingCart(1L,1L));
    Assertions.assertEquals(ErrorCodesEnum.NUMBER_OF_ORDERS_EXCEDED, exception.getCode());
  }

  @Test
  public void createShoppingCartProductTest() {

    Store store = new Store(1L);
    storeRepository.create(store);

    User user = new User(1L);
    userRepository.create(user);

    Product product = new Product(1L);
    em.persist(product);

    Category category = new Category(1L);
    em.persist(category);

    ProductStore productStore = new ProductStore(1L, product, 10, 20.0, category, store);
    productStoreRepository.create(productStore);

    ShoppingCart shoppingCart = new ShoppingCart(store, user);
    shoppingCartRepository.create(shoppingCart);

    shoppingCartProductService.createShoppingCartProduct(store.getId(), product.getId(), user.getId(), 2);

    List<ShoppingCartProduct> shoppingCartProductList = em.createQuery("SELECT s from ShoppingCartProduct s WHERE s.quantity = '2'").getResultList();
    ShoppingCartProduct shoppingCartProductToAssert = shoppingCartProductList.get(0);
    Assertions.assertNotNull(shoppingCartProductToAssert);
    Assertions.assertEquals(2, shoppingCartProductToAssert.getQuantity());

  }

  @Test
  public void productStoreDoesNotExistTest() {
    Store store = new Store(1L);
    storeRepository.create(store);

    User user = new User(1L);
    userRepository.create(user);

    Product product = new Product(1L);
    em.persist(product);
    Category category = new Category(1L);
    em.persist(category);
    ProductStore productStore = new ProductStore(1L, product, 10, 20.0, category, store);


    ShoppingCart shoppingCart = new ShoppingCart(store, user);
    shoppingCartRepository.create(shoppingCart);

    BusinessException exception = Assertions.assertThrows(BusinessException.class, () -> shoppingCartProductService.createShoppingCartProduct(store.getId(), product.getId(), user.getId(), 2));
    Assertions.assertEquals(ErrorCodesEnum.PRODUCT_STORE_NOT_FOUNDED, exception.getCode());
  }

  @Test
  public void shoppingCartDoesNotExistTest() {
    Store store = new Store(1L);
    storeRepository.create(store);

    User user = new User(1L,"carlos");
    userRepository.create(user);

    Product product = new Product(1L);
    em.persist(product);
    Category category = new Category(1L);
    em.persist(category);
    ProductStore productStore = new ProductStore(1L, product, 10, 20.0, category, store);
    productStoreRepository.create(productStore);


    shoppingCartProductService.createShoppingCartProduct(store.getId(), product.getId(), user.getId(), 2);
    List<ShoppingCartProduct> shoppingCartProductList = em.createQuery("SELECT s FROM ShoppingCartProduct s WHERE s.quantity= '2'").getResultList();
    ShoppingCartProduct shoppingCartProductToAssert = shoppingCartProductList.get(0);

    List<ShoppingCart> shoppingCartList = em.createQuery("SELECT s FROM ShoppingCart s WHERE s.user.username = 'carlos'").getResultList();
    ShoppingCart shoppingCartToAssert = shoppingCartList.get(0);
    Assertions.assertNotNull(shoppingCartToAssert);
    Assertions.assertNotNull(shoppingCartProductToAssert);
    Assertions.assertEquals(shoppingCartToAssert, shoppingCartProductToAssert.getShoppingCart());
  }
}
