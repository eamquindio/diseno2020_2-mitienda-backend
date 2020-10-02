package co.edu.eam.disenosoftware.mitienda.services;

import co.edu.eam.disenosoftware.mitienda.exceptions.BusinessException;
import co.edu.eam.disenosoftware.mitienda.exceptions.ErrorCodesEnum;
import co.edu.eam.disenosoftware.mitienda.model.entities.OrderProduct;
import co.edu.eam.disenosoftware.mitienda.repositories.OrderProductRepository;
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
public class OrderProductServiceTest {

  @Autowired
  private OrderProductService service;

  @PersistenceContext
  private EntityManager em;

  @Test
  @Sql({"/testdata/check_order_product_by_not_exist_id.sql"})
  public void checkOrderProductByNotExistIdTest () {
    BusinessException exception = Assertions.assertThrows(BusinessException.class,
            () ->service.checkOrderProductById(32L));

    Assertions.assertEquals("El producto de la orden no fue encontrado.",exception.getMessage());
    Assertions.assertEquals(ErrorCodesEnum.ORDER_PRODUCT_NOT_FOUND,exception.getCode());
  }

  @Test
  @Sql({"/testdata/check_order_product_by_id_without_state_pending.sql"})
  public void checkOrderProductByIdWithoutStatePendingTest () {

    List <OrderProduct> orderProducts = em.createQuery("SELECT op FROM OrderProduct op")
            .getResultList();

    OrderProduct orderProduct = orderProducts.get(0);

    Assertions.assertEquals(orderProduct.getQuantity(),3);
    Assertions.assertEquals(orderProduct.getState(),"canceled");

    BusinessException exception = Assertions.assertThrows(BusinessException.class,
            () ->service.checkOrderProductById(orderProduct.getId()));
    Assertions.assertEquals("Solo son validos los productos en estado pending.",exception.getMessage());
    Assertions.assertEquals(ErrorCodesEnum.ORDER_PRODUCT_IS_NOT_PENDING,exception.getCode());
  }

  @Test
  @Sql({"/testdata/check_order_product_by_id.sql"})
  public void checkOrderProductByIdTest () {
    List <OrderProduct> orderProducts = em.createQuery("SELECT op FROM OrderProduct op").getResultList();

    OrderProduct orderProduct = orderProducts.get(orderProducts.size()-1);



    Assertions.assertEquals(orderProduct.getQuantity(),3);
    Assertions.assertEquals(orderProduct.getState(),"pending");
    Assertions.assertEquals(orderProduct.getOrder().getId(), 22L);
  }

}
