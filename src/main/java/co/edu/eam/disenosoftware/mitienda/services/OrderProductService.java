package co.edu.eam.disenosoftware.mitienda.services;

import co.edu.eam.disenosoftware.mitienda.exceptions.BusinessException;
import co.edu.eam.disenosoftware.mitienda.exceptions.ErrorCodesEnum;
import co.edu.eam.disenosoftware.mitienda.model.entities.OrderProduct;
import co.edu.eam.disenosoftware.mitienda.repositories.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
