package co.edu.eam.disenosoftware.mitienda.services;

import co.edu.eam.disenosoftware.mitienda.exceptions.BusinessException;
import co.edu.eam.disenosoftware.mitienda.exceptions.ErrorCodesEnum;
import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.model.entities.OrderProduct;
import co.edu.eam.disenosoftware.mitienda.model.entities.ShoppingCart;
import co.edu.eam.disenosoftware.mitienda.model.entities.ShoppingCartProduct;
import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.model.entities.User;
import co.edu.eam.disenosoftware.mitienda.repositories.OrderProductRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.OrderRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.ShoppingCartProductRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * OrderService service
 */
@Service
@Transactional
public class OrderService {

  /**
   * Injecting shoppingCartRepository class
   */
  @Autowired
  private ShoppingCartRepository shoppingCartRepository;

  /**
   * Injecting shoppingCartProductRepository class
   */
  @Autowired
  private ShoppingCartProductRepository shoppingCartProductRepository;

  /**
   * Injecting orderProductRepository class
   */
  @Autowired
  private OrderProductRepository orderProductRepository;

  /**
   * Injecting orderRepository class
   */
  @Autowired
  private OrderRepository orderRepository;

  /**
   * entity manager to extract the list
   */
  @PersistenceContext
  private EntityManager em;


  /**
   * Create an order by the shopping cart
   * @param shoppingCartId id of the shoppingCart that we are
   *                       going to use to create the order
   */
  public void createOrderByShoppingCart(Long shoppingCartId) {

    double totalValue = 0;

    ShoppingCart shoppingCart = shoppingCartRepository.find(shoppingCartId);
    if (shoppingCart == null) {
      throw new BusinessException("Shopping Cart doesn't Exist.", ErrorCodesEnum.SHOPPING_CART_NOT_FOUND);
    }

    Store store = shoppingCart.getStore();
    User user = shoppingCart.getUser();

    if (shoppingCart.getProduct().size() == 0) {
      throw new BusinessException("Shopping Cart Products NOT Found.", ErrorCodesEnum.SHOPPING_CART_EMPTY);
    }

    final int top = 5;
    if (!(orderRepository.getOrdersInCourseByUserId(user.getId()).size() < top)) {
      throw new BusinessException("User's Orders Exceed five.", ErrorCodesEnum.NUMBER_OF_ORDERS_EXCEDED);
    }

    Order order = new Order(store, user, "created", new Date());

    List<OrderProduct> orderProducts = new ArrayList<>();
    for (ShoppingCartProduct shoppingCartProduct:shoppingCart.getProduct()) {
      OrderProduct orderProduct = new OrderProduct(order, shoppingCartProduct.getProduct(),
              shoppingCartProduct.getQuantity(), "pending");
      orderProducts.add(orderProduct);
      totalValue += (shoppingCartProduct.getProduct().getPrice() * shoppingCartProduct.getQuantity());
    }

    order.setProduct(orderProducts);
    order.setTotalValue(totalValue);

    orderRepository.create(order);

  }

  /**
   * method to check if an order is ready to end
   * @param idOrder id to find
   */
  public void finalizeOrder(Long idOrder) {

    Order order = orderRepository.find(idOrder);

    if (order == null) {
      throw new BusinessException("La orden no fue encontrada", ErrorCodesEnum.ORDER_NOT_FOUND);
    }

    List<OrderProduct> orderProducts = em.createQuery("SELECT op FROM OrderProduct op WHERE op.order.id =:value")
            .setParameter("value", idOrder)
            .getResultList();

    if (orderProducts.size() == 0) {
      throw new BusinessException("La orden no tiene elementos", ErrorCodesEnum.ORDER_DOES_NOT_HAVE_ELEMENTS);
    }

    boolean validarEstado = true;

    for (OrderProduct orderProduct: orderProducts) {

      if (orderProduct.getState().equals("pending")) {
        validarEstado = false;
        break;
      }

    }

    if (!validarEstado) {
      throw new BusinessException("Ningún producto puede estar en estado pending", ErrorCodesEnum.ORDER_IS_NOT_READY);
    }

    order.setState("finished");
    orderRepository.edit(order);

  }

}
