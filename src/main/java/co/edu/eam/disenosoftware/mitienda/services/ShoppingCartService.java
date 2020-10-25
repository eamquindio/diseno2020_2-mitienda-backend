package co.edu.eam.disenosoftware.mitienda.services;

import co.edu.eam.disenosoftware.mitienda.exceptions.BusinessException;
import co.edu.eam.disenosoftware.mitienda.exceptions.ErrorCodesEnum;
import co.edu.eam.disenosoftware.mitienda.model.entities.ShoppingCart;
import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.model.entities.User;
import co.edu.eam.disenosoftware.mitienda.repositories.ShoppingCartRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.StoreRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ShoppingCartService service
 */
@Service
@Transactional
public class ShoppingCartService {

  /**
   * shopping cart repository
   */
  @Autowired
  private ShoppingCartRepository shoppingCartRepository;

  /**
   * userRepository
   */
  @Autowired
  private UserRepository userRepository;

  /**
   * storeRepository
   */
  @Autowired
  private StoreRepository storeRepository;

  /**
   * Get a shopping cart by its user an store
   * @param userId user id
   * @param storeId store id
   * @return shoppingCart Object
   */
  public ShoppingCart getShoppingCart(Long userId, Long storeId) {

    User user = userRepository.find(userId);
    Store store = storeRepository.find(storeId);


    if (user == null) {
      throw new BusinessException("El usuario no existe", ErrorCodesEnum.USER_NOT_FOUNDED);
    }

    if (store == null) {
      throw new BusinessException("La tienda no existe", ErrorCodesEnum.STORE_NOT_FOUNDED);
    }

    return shoppingCartRepository.getShoppingCartByUserIdAndStoreId(userId, storeId);
  }
}
