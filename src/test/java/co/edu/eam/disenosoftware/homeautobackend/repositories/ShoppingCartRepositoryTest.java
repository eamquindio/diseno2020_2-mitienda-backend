package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.ShoppingCart;
import co.edu.eam.disenosoftware.homeautobackend.model.entities.Store;
import co.edu.eam.disenosoftware.homeautobackend.model.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
}
