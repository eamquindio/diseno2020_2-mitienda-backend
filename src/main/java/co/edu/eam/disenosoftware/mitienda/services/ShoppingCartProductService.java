package co.edu.eam.disenosoftware.mitienda.services;

import co.edu.eam.disenosoftware.mitienda.exceptions.BusinessException;
import co.edu.eam.disenosoftware.mitienda.exceptions.ErrorCodesEnum;
import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
import co.edu.eam.disenosoftware.mitienda.model.entities.ShoppingCart;
import co.edu.eam.disenosoftware.mitienda.model.entities.ShoppingCartProduct;
import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.model.entities.User;
import co.edu.eam.disenosoftware.mitienda.repositories.ProductStoreRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.ShoppingCartProductRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.ShoppingCartRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.StoreRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.UserRepository;
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
   * autowired
   */
  @Autowired
  private UserRepository userRepository;
  /**
   * autowired
   */
  @Autowired
  private StoreRepository storeRepository;

  /**
   * Remove Shopping Cart product from Shopping Cart
   *
   * @param idShoppingCart        Shopping Cart identifier
   * @param idShoppingCartProduct Shopping Cart Product identifier
   */
  public void removeProductFromShoppingCart(Long idShoppingCart, Long idShoppingCartProduct) {

    ShoppingCartProduct shoppingCartProduct = shoppingCartProductRepository.find(idShoppingCartProduct);

    if (shoppingCartProduct == null) {
      throw new BusinessException("El producto no existe", ErrorCodesEnum.SHOPPING_CART_PRODUCT_NOT_FOUND);
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


  /**
   * Add a product over shopping cart
   *
   * @param storeId   , store id
   * @param productId , product id
   * @param userId    , user id
   * @param quantity  , quantity of products
   */
  public void createShoppingCartProduct(Long storeId, Long productId, Long userId, int quantity) {

    User user = userRepository.find(userId);
    Store store = storeRepository.find(storeId);


    if (user == null) {
      throw new BusinessException("El usuario no existe", ErrorCodesEnum.USER_NOT_FOUNDED);
    }

    if (store == null) {
      throw new BusinessException("La tienda no existe", ErrorCodesEnum.STORE_NOT_FOUNDED);
    }

    ShoppingCart shoppingCartOne = shoppingCartRepository.getShoppingCartByUserIdAndStoreId(userId, storeId);

    if (shoppingCartOne == null) {
      shoppingCartOne = new ShoppingCart(store, user);
      shoppingCartRepository.create(shoppingCartOne);
    }

    ProductStore productStoreOne = productStoreRepository
            .getProductStoreByProductIdAndStoreId(productId, store.getId());

    if (productStoreOne == null) {
      throw new BusinessException("El producto no existe", ErrorCodesEnum.PRODUCT_STORE_NOT_FOUNDED);
    }

    ShoppingCartProduct shoppingCartProduct = new ShoppingCartProduct(shoppingCartOne, productStoreOne, quantity);
    shoppingCartProductRepository.create(shoppingCartProduct);

  }
}
