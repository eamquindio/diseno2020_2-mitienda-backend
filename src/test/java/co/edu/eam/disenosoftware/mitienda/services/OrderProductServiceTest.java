package co.edu.eam.disenosoftware.mitienda.services;

import co.edu.eam.disenosoftware.mitienda.exceptions.BusinessException;
import co.edu.eam.disenosoftware.mitienda.exceptions.ErrorCodesEnum;
import co.edu.eam.disenosoftware.mitienda.model.entities.OrderProduct;
import co.edu.eam.disenosoftware.mitienda.repositories.OrderProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.repositories.OrderRepository;
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

  @Autowired
  private OrderProductRepository orderProductRepository;

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

    service.checkOrderProductById(orderProduct.getId());

    OrderProduct orderProductToAssert = orderProductRepository.find(orderProduct.getId());

    Assertions.assertEquals(orderProduct.getId(),orderProductToAssert.getId());
    Assertions.assertEquals(orderProduct.getQuantity(),3);
    Assertions.assertEquals(orderProduct.getState(),"checked");
    Assertions.assertEquals(orderProduct.getOrder().getId(), 22L);
  }


  @Autowired
  private OrderRepository orderRepository;

  @Test
  @Sql({"/testdata/adding_product_to_order_product_can_not_adding_product.sql"})
  public void addingProductToOrderProductCannotAddProductTest(){


     BusinessException exception = Assertions.assertThrows(BusinessException.class,
            () ->service.addingProductToOrderProduct(77L,1L,1));
     Assertions.assertEquals("El product no puede ser agregado", exception.getMessage());
     Assertions.assertEquals(ErrorCodesEnum.PRODUCT_CAN_NOT_BE_ADDED, exception.getCode());

  }

  @Test
  @Sql({"/testdata/adding_product_to_order_product.sql"})
  public void addingProductToOrderProductTest(){

    OrderProduct orderProduct= service.addingProductToOrderProduct(77L,1L,1);
    Order order=orderRepository.find(1L);
    Assertions.assertEquals(1,order.getProduct().get(1).getQuantity());

  }

  @Test
  @Sql({"/testdata/adding_product_to_order_product_store_is_not_the_same_at_product_store.sql"})
  public void addingProductToOrderProductStoreIsNotTheSameAtProductStoreTest(){

    BusinessException exception = Assertions.assertThrows(BusinessException.class,
            () ->service.addingProductToOrderProduct(77L,1L,1));
    Assertions.assertEquals("La Orden no fue encontrada", exception.getMessage());
    Assertions.assertEquals(ErrorCodesEnum.NOT_ASSOCIATED_STORE, exception.getCode());

  }

  @Test
  @Sql({"/testdata/adding_product_to_order_product_total_value_of_product_exceed_10_porcent_of_total_value_order.sql"})
  public void addingProductToOrderProductTotalValueOfProductExceed10PorcentOfTotalValueOrderTest(){

    BusinessException exception = Assertions.assertThrows(BusinessException.class,
            () ->service.addingProductToOrderProduct(77L,1L,1));
    Assertions.assertEquals("El total del product excede el 10% del total de la Orden", exception.getMessage());
    Assertions.assertEquals(ErrorCodesEnum.PRODUCT_EXCIT_TOTALVALUE, exception.getCode());

  }
}
