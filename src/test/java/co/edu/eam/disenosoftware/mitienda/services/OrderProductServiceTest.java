package co.edu.eam.disenosoftware.mitienda.services;

import co.edu.eam.disenosoftware.mitienda.exceptions.BusinessException;
import co.edu.eam.disenosoftware.mitienda.model.entities.OrderProduct;
import co.edu.eam.disenosoftware.mitienda.repositories.OrderProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@SpringBootTest
public class OrderProductServiceTest {

  @Autowired
  private OrderProductService service;

  @PersistenceContext
  private EntityManager em;

  @Test
  public void checkOrderProductByNotExistIdTest () {
    OrderProduct orderProduct = new OrderProduct(2,"pending");
    em.persist(orderProduct);
    Long orderProductId = orderProduct.getId();

    Exception exception = Assertions.assertThrows(BusinessException.class,
            () ->service.checkOrderProductById(32L));

    Assertions.assertEquals("El producto de la orden no fue encontrado.",exception.getMessage());
  }

  @Test
  public void checkOrderProductByIdWithoutStatePendingTest () {
    OrderProduct orderProduct = new OrderProduct(2,"initial");
    em.persist(orderProduct);
    Long orderProductId = orderProduct.getId();

    List <OrderProduct> orderProducts = em.createQuery("SELECT op FROM OrderProduct op WHERE op.id = :value")
            .setParameter("value",orderProductId).getResultList();

    orderProduct = orderProducts.get(0);

    Assertions.assertEquals(orderProduct.getQuantity(),2);
    Assertions.assertEquals(orderProduct.getState(),"initial");

    Exception exception = Assertions.assertThrows(BusinessException.class,
            () ->service.checkOrderProductById(orderProductId));
    Assertions.assertEquals("Solo se pueden checkear los productos en estado pending.",exception.getMessage());
  }

  @Test
  public void checkOrderProductByIdTest () {
    OrderProduct orderProduct = new OrderProduct(2,"pending");
    em.persist(orderProduct);
    Long orderProductId = orderProduct.getId();

    List <OrderProduct> orderProducts = em.createQuery("SELECT op FROM OrderProduct op WHERE op.id = :value")
            .setParameter("value",orderProductId).getResultList();

    orderProduct = orderProducts.get(0);

    Assertions.assertEquals(orderProduct.getQuantity(),2);
    Assertions.assertEquals(orderProduct.getState(),"pending");
  }

}
