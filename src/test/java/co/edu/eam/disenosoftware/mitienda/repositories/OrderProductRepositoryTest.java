package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.model.entities.OrderProduct;
import co.edu.eam.disenosoftware.mitienda.model.entities.Product;
import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
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
public class OrderProductRepositoryTest {

  @Autowired
  private OrderProductRepository repository;

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
  public void createNotExistOrderProductTest(){
    Order order = new Order(12L);
    em.persist(order);
    Product product = new Product(11L);
    em.persist(product);
    ProductStore productStore = new ProductStore(10L);
    em.persist(productStore);
    OrderProduct orderProduct = new OrderProduct(1L, order, productStore, 21, "activo");
    repository.create(orderProduct);

    OrderProduct orderProductToAssert = repository.find(1L);

    Assertions.assertNotNull(orderProductToAssert);
    Assertions.assertEquals(21, orderProductToAssert.getQuantity());
  }

  @Test
  public void deleteExistingOrderProductTest(){
    Order order = new Order(12L);
    em.persist(order);
    ProductStore productStore = new ProductStore(10L);
    repository.create(new OrderProduct(1L, order, productStore, 21, "activo"));

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
  public void findExistingOrderProductTest(){
    Order order = new Order(12L);
    em.persist(order);
    Product product = new Product(11L);
    em.persist(product);
    ProductStore productStore = new ProductStore(10L);
    em.persist(productStore);
    OrderProduct orderProduct = new OrderProduct(1L, order, productStore, 21, "activo");
    em.persist(orderProduct);

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
  public void updateOrderProductTest(){
    Order order = new Order(12L);
    em.persist(order);
    Product product = new Product(11L);
    em.persist(product);
    ProductStore productStore = new ProductStore(10L);
    em.persist(productStore);
    OrderProduct orderProduct = new OrderProduct(1L, order, productStore, 21, "activo");
    em.persist(orderProduct);

    orderProduct.setQuantity(24);
    repository.edit(orderProduct);

    OrderProduct orderProductAssert = repository.find(1L);
    Assertions.assertEquals(24, orderProductAssert.getQuantity());
  }

}
