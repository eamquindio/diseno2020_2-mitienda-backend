package co.edu.eam.disenosoftware.mitienda.services;

import co.edu.eam.disenosoftware.mitienda.exceptions.BusinessException;
import co.edu.eam.disenosoftware.mitienda.exceptions.ErrorCodesEnum;
import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
import co.edu.eam.disenosoftware.mitienda.model.entities.ShoppingCart;
import co.edu.eam.disenosoftware.mitienda.model.entities.ShoppingCartProduct;
import co.edu.eam.disenosoftware.mitienda.repositories.ShoppingCartProductRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.ShoppingCartRepository;
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
public class ShoppingCartProductServiceTest {

  @PersistenceContext
  private EntityManager em;

  @Autowired
  private ShoppingCartProductService shoppingCartProductService;

  @Autowired
  private ShoppingCartRepository shoppingCartRepository;

  @Autowired
  private ShoppingCartProductRepository shoppingCartProductRepository;

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
}
