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
}
