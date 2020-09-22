package co.edu.eam.disenosoftware.mitienda.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.model.entities.OrderProduct;
import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.model.request.CreateOrderRequest;
import co.edu.eam.disenosoftware.mitienda.repositories.OrderRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.ProductStoreRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(Routes.ORDERS_PATH)
public class OrderController {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private StoreRepository storeRepository;

  @Autowired
  private ProductStoreRepository productStoreRepository;

  @GetMapping(Routes.GET_ORDER)
  public Order getOrder(@PathVariable Long orderId) {
    return orderRepository.find(orderId);
  }

  @PostMapping("")
  public void createOrder(@RequestBody CreateOrderRequest createOrder) {

    Order order = new Order();
    order.setDate(new Date());
    order.setState("created");

    Store store = storeRepository.find(createOrder.getStoreId());
    order.setStore(store);


    List<ProductStore> ps = productStoreRepository.getProductsStoreByStoreId(store.getId());

    List<OrderProduct> products = new ArrayList<>();
    for(ProductStore p:ps){
      OrderProduct product = new OrderProduct();
      product.setOrder(order);
      product.setProductStore(p);
      product.setQuantity(1);
      product.setState("pending");
      products.add(product);
    }

    order.setProduct(products);

    orderRepository.create(order);


  }
}
