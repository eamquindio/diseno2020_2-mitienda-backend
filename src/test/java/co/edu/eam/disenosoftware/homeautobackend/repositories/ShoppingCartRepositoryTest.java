package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.ShoppingCart;
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

}
