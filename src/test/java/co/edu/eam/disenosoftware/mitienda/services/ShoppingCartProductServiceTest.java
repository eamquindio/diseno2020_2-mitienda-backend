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
    Assertions.assertEquals(ErrorCodesEnum.SHOPPING_CART_PRODUCT_NOT_FOUND, exception.getCode());
  }

  @Test
  @Sql({"/testdata/create_shopping_cart_does_not_exist_test.sql"})
  public void createShoppingCartProductTest() {

    shoppingCartProductService.createShoppingCartProduct(1L, 1L, 1L, 2);

    List<ShoppingCartProduct> shoppingCartProductList = em.createQuery("SELECT s from ShoppingCartProduct s WHERE s.shoppingCart.user.username = 'carlos'").getResultList();
    ShoppingCartProduct shoppingCartProductToAssert = shoppingCartProductList.get(0);

    Assertions.assertNotNull(shoppingCartProductToAssert);
    Assertions.assertEquals("carlos",shoppingCartProductToAssert.getShoppingCart().getUser().getUsername());

    ShoppingCartProduct shoppingCartProductProvement = shoppingCartProductRepository.find(shoppingCartProductToAssert.getId());
    Assertions.assertEquals(shoppingCartProductProvement.getId(),shoppingCartProductToAssert.getId());

  }

  @Test
  @Sql({"/testdata/product_store_does_not_exist_test.sql"})
  public void productStoreDoesNotExistTest() {

    BusinessException exception = Assertions.assertThrows(BusinessException.class, () -> shoppingCartProductService.createShoppingCartProduct(1L, 1L, 1L, 2));
    Assertions.assertEquals(ErrorCodesEnum.PRODUCT_STORE_NOT_FOUNDED, exception.getCode());
  }

  @Test
  @Sql({"/testdata/shopping_cart_does_not_exist_test.sql"})
  public void shoppingCartDoesNotExistTest() {

    shoppingCartProductService.createShoppingCartProduct(1L, 1L, 1L, 2);

    List<ShoppingCartProduct> shoppingCartProductList = em.createQuery("SELECT s FROM ShoppingCartProduct s WHERE s.shoppingCart.user.username = 'carlos'").getResultList();

    ShoppingCartProduct shoppingCartProductToAssert = shoppingCartProductList.get(0);

    Assertions.assertNotNull(shoppingCartProductToAssert);
    Assertions.assertEquals("carlos",shoppingCartProductToAssert.getShoppingCart().getUser().getUsername());

    ShoppingCartProduct shoppingCartProductProvement = shoppingCartProductRepository.find(shoppingCartProductToAssert.getId());
    Assertions.assertEquals(shoppingCartProductProvement.getShoppingCart().getId(), shoppingCartProductToAssert.getShoppingCart().getId());
    Assertions.assertEquals(shoppingCartProductProvement.getId(), shoppingCartProductToAssert.getId());
  }

  @Test
  @Sql({"/testdata/user_does_not_exist_test.sql"})
  public void UserDoesNotExistTest() {

    BusinessException exception = Assertions.assertThrows(BusinessException.class, () -> shoppingCartProductService.createShoppingCartProduct(1L, 1L, 1L, 2));
    Assertions.assertEquals(ErrorCodesEnum.USER_NOT_FOUNDED, exception.getCode());
  }

  @Test
  @Sql({"/testdata/store_does_not_exist_test.sql"})
  public void StoreDoesNotExistTest() {

    BusinessException exception = Assertions.assertThrows(BusinessException.class, () -> shoppingCartProductService.createShoppingCartProduct(1L, 1L, 1L, 2));
    Assertions.assertEquals(ErrorCodesEnum.STORE_NOT_FOUNDED, exception.getCode());
  }

}
