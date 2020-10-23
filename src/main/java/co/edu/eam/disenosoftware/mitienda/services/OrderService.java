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
import co.edu.eam.disenosoftware.mitienda.repositories.StoreRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.UserRepository;
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
   * Injecting userRepository class
   */
  @Autowired
  private UserRepository userRepository;

  /**
   * Injecting storeRepository class
   */
  @Autowired
  private StoreRepository storeRepository;
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

    List<OrderProduct> orderProducts = orderProductRepository.getAllOrderProductsByIdOrder(idOrder);

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

  /**
   * method to change statu's order to delived
   * @param idOrder id to find
   */
  public void deliverOrder(Long idOrder) {

    Order order = orderRepository.find(idOrder);

    if (order == null) {

      throw new BusinessException("Order does not exist.", ErrorCodesEnum.ORDER_NOT_FOUND);

    } else {

      if (order.getState().equals("finished")) {

        order.setState("delivered");
        orderRepository.edit(order);

      } else {
        throw new BusinessException("the state´s order is not finished", ErrorCodesEnum.ORDER_CAN_NOT_BE_DELIVERED);
      }

    }

  }
  /**
   * Method to call List of get orders by user id in service
   * @param idUser , id of user
   * @return list of orders
   */
  public List<Order> getOrdersByUserId(Long idUser) {
    User user = userRepository.find(idUser);
    if (user == null) {
      throw new BusinessException("User does not exist.", ErrorCodesEnum.USER_NOT_FOUNDED);
    }
    return orderRepository.getOrdersInCourseByUserId(idUser);
  }

  /**
   * Method to get order by orderId
   * @param id to find
   * @return order find
   */
  public Order getOrderByID(Long id) {
    Order order = orderRepository.find(id);
    if (order == null) {
      throw new BusinessException("Order not found", ErrorCodesEnum.ORDER_NOT_FOUND);
    }
    return order;
  }

  /**
   * Method to call List of get orders by store id in service
   * @param idStore , id of store
   * @return list of orders
   */
  public List<Order> getOrdersByStoreId(Long idStore) {
    Store store = storeRepository.find(idStore);
    if (store == null) {
      throw new BusinessException("Store does not exist.", ErrorCodesEnum.STORE_NOT_FOUNDED);
    }
    return orderRepository.getOrdersByStore(idStore);
  }
}
