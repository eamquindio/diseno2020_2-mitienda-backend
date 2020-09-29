package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
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
  public void createNotExistingOrderTest(){
    User user = new User(1L);
    em.persist(user);

    Order order = new Order(2L,user,"in_progress");

    orderRepository.create(order);

    Order orderToAssert = orderRepository.find(2L);
    Assertions.assertNotNull(orderToAssert);
    Assertions.assertEquals(2L,orderToAssert.getId());
    Assertions.assertEquals(1L,orderToAssert.getUser().getId());
  }

  @Test
  public void deleteExistingOrderTest(){
    User user = new User();

    Order order = new Order(1L,user,"in_progress");

    orderRepository.create(order);

    Order deleteOrder = orderRepository.delete(1L);

    Order orderToAssert = orderRepository.find(1L);

    Assertions.assertNull(orderToAssert);
    Assertions.assertNotNull(deleteOrder);
    Assertions.assertEquals(order, deleteOrder);
  }

  @Test
  public void deleteNotExistingOrderTest(){
    Order deletedOrder = orderRepository.delete(1L);
    Assertions.assertNull(deletedOrder);
  }

  @Test
  public void findExistingOrderTest(){
    User user = new User(1L);
    em.persist(user);

    Order order = new Order(2L,user,"in_progress");
    em.persist(order);

    Order orderToAssert = orderRepository.find(2L);

    Assertions.assertNotNull(orderToAssert);
    Assertions.assertEquals(2L, orderToAssert.getId());
    Assertions.assertEquals(order, orderToAssert);
  }

  @Test
  public void findNotExistingOrderTest(){
    Order orderToAssert = orderRepository.find(1L);
    Assertions.assertNull(orderToAssert);
  }

  @Test
  public void updateExistingOrderTest(){
    User user = new User(1L);
    em.persist(user);

    Order order = new Order(2L,user,"in_progress");
    em.persist(order);

    order.setState("done");
    orderRepository.edit(order);

    Order orderToAssert = orderRepository.find(2L);

    Assertions.assertNotNull(orderToAssert);
    Assertions.assertEquals("done",orderToAssert.getState());
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

  /**
   * Test for getFinishedOrdersByUserId with a sql
   */
  @Test
  @Sql({"/testdata/get_finished_orders_by_user_id.sql"})
  public void getFinishedOrdersByUserIdTest(){

    List<Order> ordersFinishedToAssert = orderRepository.getFinishedOrdersByUserId(1L);

    Assertions.assertEquals(5, ordersFinishedToAssert.size());
  }
}
