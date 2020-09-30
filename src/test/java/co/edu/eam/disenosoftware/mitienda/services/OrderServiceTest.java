package co.edu.eam.disenosoftware.mitienda.services;

import co.edu.eam.disenosoftware.mitienda.exceptions.BusinessException;
import co.edu.eam.disenosoftware.mitienda.exceptions.ErrorCodesEnum;
import co.edu.eam.disenosoftware.mitienda.exceptions.NotFoundException;
import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.model.entities.OrderProduct;
import co.edu.eam.disenosoftware.mitienda.repositories.OrderProductRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.OrderRepository;
import org.junit.jupiter.api.Assertions;
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
public class OrderServiceTest {

  @Autowired
  private OrderService service;

  @Autowired
  private OrderRepository repository;

  @Autowired
  private OrderProductRepository orderProductRepository;

  @PersistenceContext
  private EntityManager em;

  @Test
  @Sql("/testdata/create_order_by_shopping_cart_test.sql")
  public void createOrderByShoppingCartTest() {
    //Test Code
    service.createOrderByShoppingCart(1L);

    //Test Verification

    List<Order> orderToAssert = repository.getOrdersInCourseByUserId(1L);

    Assertions.assertNotNull(orderToAssert);
    Assertions.assertEquals("created", orderToAssert.get(orderToAssert.size()-1).getState());
    Assertions.assertEquals(16000, orderToAssert.get(orderToAssert.size()-1).getTotalValue());
    Assertions.assertEquals(1L, orderToAssert.get(orderToAssert.size()-1).getUser().getId());
    Assertions.assertEquals(1L, orderToAssert.get(orderToAssert.size()-1).getStore().getId());

    List<OrderProduct> orderProductToAssert = em.createQuery("SELECT op FROM OrderProduct op WHERE op.order.id = :id").setParameter("id", orderToAssert.get(orderToAssert.size()-1).getId()).getResultList();

    Assertions.assertEquals(orderToAssert.get(orderToAssert.size()-1).getId(), orderProductToAssert.get(orderProductToAssert.size()-3).getOrder().getId());
    Assertions.assertEquals(orderToAssert.get(orderToAssert.size()-1).getId(), orderProductToAssert.get(orderProductToAssert.size()-2).getOrder().getId());
    Assertions.assertEquals(orderToAssert.get(orderToAssert.size()-1).getId(), orderProductToAssert.get(orderProductToAssert.size()-1).getOrder().getId());

  }

  @Test
  @Sql("/testdata/create_order_when_user_orders_exceed_five_test.sql")
  public void createOrderWhenUserOrdersExceedFive() {
    //Test Code
    try{
      for (int i = 0; i < 6; i++) {
        service.createOrderByShoppingCart(1L);
      }
    }catch (BusinessException e){
      Assertions.assertEquals("User's Orders Exceed five.", e.getMessage());
      Assertions.assertEquals(ErrorCodesEnum.ORDER_USER_EXCEED_FIVE, e.getCode());
    }

    List<Order> orderToAssert = repository.getOrdersInCourseByUserId(1L);

    Assertions.assertEquals(5, orderToAssert.size());
  }

  @Test
  public void createOrderWithoutShoppingCartTest() {
    //Test Code
    List<Order> orderToAssertTwo = repository.getOrdersInCourseByUserId(1L);
    try{
        service.createOrderByShoppingCart(1L);
    }catch (NotFoundException e){
      Assertions.assertEquals("Shopping Cart doesn't Exist.", e.getMessage());
      Assertions.assertEquals(ErrorCodesEnum.NOT_FOUND, e.getErrorCode());
    }

    List<Order> orderToAssertThree = repository.getOrdersInCourseByUserId(1L);
    List<Order> orderToAssert = repository.getOrdersInCourseByUserId(1L);
    Assertions.assertEquals(0,orderToAssert.size());
    Assertions.assertEquals(orderToAssertTwo, orderToAssertThree);
  }

  @Test
  @Sql("/testdata/create_order_without_products_test.sql")
  public void createOrderWithoutShoppingCartProductsTest() {
    List<Order> orderToAssertTwo = repository.getOrdersInCourseByUserId(1L);
    //Test Code
    try{
      service.createOrderByShoppingCart(1L);
    }catch (NotFoundException e){
      Assertions.assertEquals("Shopping Cart Products NOT Found.", e.getMessage());
      Assertions.assertEquals(ErrorCodesEnum.NOT_FOUND, e.getErrorCode());
    }

    List<Order> orderToAssertThree = repository.getOrdersInCourseByUserId(1L);
    List<Order> orderToAssert = repository.getOrdersInCourseByUserId(1L);
    Assertions.assertEquals(0,orderToAssert.size());
    Assertions.assertEquals(orderToAssertTwo, orderToAssertThree);
  }

}
