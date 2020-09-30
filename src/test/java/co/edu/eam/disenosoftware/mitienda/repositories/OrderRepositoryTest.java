package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
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
import java.util.Date;
import java.util.List;

@Transactional
@SpringBootTest
public class OrderRepositoryTest {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private StoreRepository storeRepository;

  @Autowired
  private UserRepository userRepository;

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
  @Sql("/testdata/create_not_existing_order_test.sql")
  public void createNotExistingOrderTest(){

    Store store = storeRepository.find(1L);
    User user = userRepository.find(1L);

    Order order = new Order(store, user, "created", new Date());

    orderRepository.create(order);

    List<Order> orderToAssert = em.createQuery("SELECT o FROM Order o").getResultList();
    Assertions.assertNotNull(orderToAssert);
    Assertions.assertEquals("created",orderToAssert.get(orderToAssert.size()-1).getState());
    Assertions.assertEquals(1L,orderToAssert.get(orderToAssert.size()-1).getStore().getId());
    Assertions.assertEquals(1L,orderToAssert.get(orderToAssert.size()-1).getUser().getId());
  }

  @Test
  @Sql("/testdata/find_update_delete_existing_order_test.sql")
  public void deleteExistingOrderTest(){

    Order deleteOrder = orderRepository.delete(1L);

    Order orderToAssert = orderRepository.find(1L);

    Assertions.assertNull(orderToAssert);
    Assertions.assertNotNull(deleteOrder);
  }

  @Test
  public void deleteNotExistingOrderTest(){
    Order deletedOrder = orderRepository.delete(1L);
    Assertions.assertNull(deletedOrder);
  }

  @Test
  @Sql("/testdata/find_update_delete_existing_order_test.sql")
  public void findExistingOrderTest(){

    Order orderToAssert = orderRepository.find(1L);

    Assertions.assertNotNull(orderToAssert);
    Assertions.assertEquals(1L, orderToAssert.getId());
    Assertions.assertEquals(1L, orderToAssert.getUser().getId());
    Assertions.assertEquals(1L, orderToAssert.getStore().getId());
  }

  @Test
  public void findNotExistingOrderTest(){
    Order orderToAssert = orderRepository.find(1L);
    Assertions.assertNull(orderToAssert);
  }

  @Test
  @Sql("/testdata/find_update_delete_existing_order_test.sql")
  public void updateExistingOrderTest(){
    Order order = orderRepository.find(1L);

    order.setState("done");
    orderRepository.edit(order);

    Order orderToAssert = orderRepository.find(1L);

    Assertions.assertNotNull(orderToAssert);
    Assertions.assertEquals("done",orderToAssert.getState());
  }

  @Test
  @Sql("/testdata/get_order_in_course_by_user_id_test.sql")
  public void getOrdersInCourseByUserIdTest(){
    List<Order> ordersInCourseListToAssert = orderRepository.getOrdersInCourseByUserId(1L);
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
