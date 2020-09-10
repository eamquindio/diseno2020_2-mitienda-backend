package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.Order;
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
public class OrderRepositoryTest {

  @Autowired
  private OrderRepository orderRepository;

  @PersistenceContext
  private EntityManager em;

  @BeforeEach
  public void setup() {
    em.createQuery("delete from Order");
  }

  @Test
  public void test() {
    Assertions.assertTrue(true);
  }

  @Test
  public void getOrdersInCourseByUserIdTest(){

    User user = new User(1L);
    User userTwo = new User(2L);

    em.persist(user);
    em.persist(userTwo);

    em.persist(new Order(1L,user,"in_progress"));
    em.persist(new Order(2L,user,"created"));
    em.persist(new Order(3L,userTwo,"in_progress"));
    em.persist(new Order(4L,userTwo,"created"));

    List<Order> ordersInCourseListToAssert = orderRepository.getOrdersInCourseByUserId(2L);
    Assertions.assertEquals(2, ordersInCourseListToAssert.size());
  }

}
