package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.exceptions.BusinessException;
import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.model.entities.OrderProduct;
import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
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
public class OrderProductRepositoryTest {

  @Autowired
  private OrderProductRepository repository;

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private ProductStoreRepository productStoreRepository;

  @PersistenceContext
  private EntityManager em;

  @BeforeEach
  public void setup() {
    em.createQuery("delete from OrderProduct");
  }

  @Test
  public void test() {
    Assertions.assertTrue(true);
  }

  @Test
  @Sql("/testdata/create_not_existing_order_product_text.sql")
  public void createNotExistOrderProductTest(){
    Order order = orderRepository.find(12L);
    ProductStore productStore = productStoreRepository.find(11L);

    OrderProduct orderProduct = new OrderProduct(order, productStore, 21, "activo");

    repository.create(orderProduct);

    List<OrderProduct> orderProductToAssert = em.createQuery("SELECT op FROM OrderProduct op").getResultList();

    Assertions.assertNotNull(orderProductToAssert.get(orderProductToAssert.size()-1));
    Assertions.assertEquals(21, orderProductToAssert.get(orderProductToAssert.size()-1).getQuantity());
  }

  @Test
  @Sql("/testdata/delete_and_find_existing_order_product_test.sql")
  public void deleteExistingOrderProductTest(){

    OrderProduct deleteOrderProduct = repository.delete(1L);
    Assertions.assertNotNull(deleteOrderProduct);
    Assertions.assertEquals(21, deleteOrderProduct.getQuantity());

    OrderProduct orderProductAssert = em.find(OrderProduct.class, 1L);
    Assertions.assertNull(orderProductAssert);
  }

  @Test
  public void deleteNotExistingOrderProductTest(){
    OrderProduct deleteOrderProduct = repository.delete(1L);
    Assertions.assertNull(deleteOrderProduct);
  }

  @Test
  @Sql("/testdata/delete_and_find_existing_order_product_test.sql")
  public void findExistingOrderProductTest(){

    OrderProduct orderProductToAssert = repository.find(1L);

    Assertions.assertNotNull(orderProductToAssert);
    Assertions.assertEquals(21, orderProductToAssert.getQuantity());
  }

  @Test
  public void findNotExistingOrderProductTest(){
    OrderProduct orderProductToAssert = repository.find(1L);
    Assertions.assertNull(orderProductToAssert);
  }

  @Test
  @Sql("/testdata/update_order_product_test.sql")
  public void updateOrderProductTest(){

    OrderProduct orderProduct = repository.find(1L);

    orderProduct.setQuantity(24);
    repository.edit(orderProduct);

    OrderProduct orderProductAssert = repository.find(1L);
    Assertions.assertEquals(24, orderProductAssert.getQuantity());
  }
    
  @Test
  @Sql({"/testdata/get_all_order_products_by_not_found_id_order.sql"})
  public void getAllProductsByNotFoundIdOrder () {
    List<OrderProduct> orderProducts = repository.getAllOrderProductsByIdOrder(32l);
    Assertions.assertEquals(0,orderProducts.size());
  }

  @Test
  @Sql({"/testdata/get_all_order_products_by_found_id_order.sql"})
  public void getAllProductsByFoundIdOrder () {
    List<OrderProduct> orderProducts = repository.getAllOrderProductsByIdOrder(1l);
    Assertions.assertEquals(3,orderProducts.size());
  }
}
