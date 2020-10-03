package co.edu.eam.disenosoftware.mitienda.services;

import co.edu.eam.disenosoftware.mitienda.exceptions.BusinessException;
import co.edu.eam.disenosoftware.mitienda.exceptions.ErrorCodesEnum;
import co.edu.eam.disenosoftware.mitienda.model.entities.OrderProduct;
import co.edu.eam.disenosoftware.mitienda.repositories.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.repositories.OrderRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.ProductStoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * OrderProductService service
 */
@Service
@Transactional
public class OrderProductService {

  /**
   * orderProductRepository to find the order product
   */
  @Autowired
  private OrderProductRepository orderProductRepository;

  /**
   * method to check if an order product is in state "pending"
   * @param idOrderProduct id to find
   */
  public void checkOrderProductById(Long idOrderProduct) {
    OrderProduct orderProductFind = orderProductRepository.find(idOrderProduct);
    String state = "";

    if (orderProductFind == null) {
      throw new BusinessException("El producto de la orden no fue encontrado.", ErrorCodesEnum.ORDER_PRODUCT_NOT_FOUND);
    }

    state = orderProductFind.getState();

    if (state.equals("pending")) {
      orderProductFind.setState("checked");
      orderProductRepository.edit(orderProductFind);
    } else {
      throw new BusinessException("Solo son validos los productos en estado pending.",
              ErrorCodesEnum.ORDER_PRODUCT_IS_NOT_PENDING);
    }

  }
  /**
   * Repository for find order
   */
  @Autowired
  private OrderRepository ordenRepository;

  /**
   * Repository for find productStore
   */
  @Autowired
  private ProductStoreRepository productStoreRepository;

  /**
   * Adding a product to Order
   *
   * @param idProduct , Foreign key
   * @param idOrder , Foreign key
   * @param quantity , Integer
   * @return a order or null if not exists
   */
  public OrderProduct addingProductToOrderProduct(Long idProduct, Long idOrder, Integer quantity) {
    final double porcent = 0.1;
    Order orderToFind = ordenRepository.find(idOrder);



    if (orderToFind.getState().equals("canceled") || orderToFind.getState().equals("finished")) {

      throw new BusinessException("El product no puede ser agregado",
               ErrorCodesEnum.PRODUCT_CAN_NOT_BE_ADDED);
    }

    Store store = orderToFind.getStore();
    ProductStore productStoreToFind = productStoreRepository.
             getProductStoreByIdStoreAndProductId(store.getId(), idProduct);

    if (productStoreToFind == null) {

      throw new BusinessException("La Orden no fue encontrada", ErrorCodesEnum.NOT_ASSOCIATED_STORE);
    }

    for (OrderProduct product:orderToFind.getProduct()) {

      if (idProduct == product.getId()) {
        product.setQuantity(product.getQuantity() + quantity);

        if (product.getProductStore().getPrice()
                 * product.getQuantity()
                 > orderToFind.getTotalValue() * porcent) {
          throw new BusinessException("El total del product excede el 10% del total de la Orden",
                   ErrorCodesEnum.PRODUCT_EXCIT_TOTALVALUE);
        }
        ordenRepository.edit(orderToFind);

        return product;

      }
    }
    if (productStoreToFind.getPrice() * quantity > orderToFind.getTotalValue() * porcent) {
      throw new BusinessException("El total del product excede el 10% del total de la Orden",
               ErrorCodesEnum.PRODUCT_EXCIT_TOTALVALUE);
    }

    OrderProduct orderProduct = new OrderProduct(1L, orderToFind, productStoreToFind, quantity, "created");
    orderToFind.getProduct().add(orderProduct);
    ordenRepository.edit(orderToFind);
    return orderProduct;
  }

}
