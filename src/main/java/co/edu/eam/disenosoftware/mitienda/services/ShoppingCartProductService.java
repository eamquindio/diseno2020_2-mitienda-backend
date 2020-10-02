package co.edu.eam.disenosoftware.mitienda.services;

import co.edu.eam.disenosoftware.mitienda.exceptions.BusinessException;
import co.edu.eam.disenosoftware.mitienda.exceptions.ErrorCodesEnum;
import co.edu.eam.disenosoftware.mitienda.model.entities.ShoppingCart;
import co.edu.eam.disenosoftware.mitienda.model.entities.ShoppingCartProduct;
import co.edu.eam.disenosoftware.mitienda.repositories.ProductStoreRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.ShoppingCartProductRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ShoppingCartProductService service
 */
@Service
@Transactional
public class ShoppingCartProductService {

  /**
   * Shopping Cart Repository
   */
  @Autowired
  private ShoppingCartRepository shoppingCartRepository;

  /**
   * Shopping Cart Product Repository
   */
  @Autowired
  private ShoppingCartProductRepository shoppingCartProductRepository;

  /**
   * Product Store Repository
   */
  @Autowired
  private ProductStoreRepository productStoreRepository;

  /**
   * Remove Shopping Cart product from Shopping Cart
   * @param idShoppingCart Shopping Cart identifier
   * @param idShoppingCartProduct Shopping Cart Product identifier
   */
  public void removeProductFromShoppingCart(Long idShoppingCart, Long idShoppingCartProduct) {

    ShoppingCartProduct shoppingCartProduct = shoppingCartProductRepository.find(idShoppingCartProduct);

    if (shoppingCartProduct == null) {
      throw new BusinessException("El producto no existe", ErrorCodesEnum.NUMBER_OF_ORDERS_EXCEDED);
    }

    List<ShoppingCartProduct> products =
            shoppingCartProductRepository.getShoppingCartProductsByShoppingCartId(idShoppingCart);

    if (products.size() == 1) {
      shoppingCartRepository.delete(idShoppingCart);
      shoppingCartProductRepository.delete(idShoppingCartProduct);
    } else {
      ShoppingCartProduct delete = shoppingCartProductRepository.delete(idShoppingCartProduct);
      ShoppingCart shoppingCart = shoppingCartRepository.find(idShoppingCart);

      double totalValue = shoppingCart.getTotalValue() - delete.getProduct().getPrice() * delete.getQuantity();

      shoppingCart.setTotalValue(totalValue);
      shoppingCartRepository.edit(shoppingCart);
    }
  }
}
