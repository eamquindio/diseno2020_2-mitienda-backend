package co.edu.eam.disenosoftware.mitienda.services;

import co.edu.eam.disenosoftware.mitienda.exceptions.BusinessException;
import co.edu.eam.disenosoftware.mitienda.exceptions.ErrorCodesEnum;
import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.repositories.StoreRepository;
import co.edu.eam.disenosoftware.mitienda.utils.EncrypterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * StoreService service
 */
@Service
@Transactional
public class StoreService {

  /**
   * StoreRepository storeRepository
   */
  @Autowired
  private StoreRepository storeRepository;

  /**
   * Service register Store
   * @param name name store
   * @param owner owner store
   * @param address address store
   * @param phone phone store
   * @param email email store
   * @param password password store
   */
  public void registerStore(String name, String owner, String address, String phone, String email, String password) {
    Store nameToFind = storeRepository.getStoreByName(name);

    if (nameToFind != null) {
      throw new BusinessException("Ya existe el nombre ingresado", ErrorCodesEnum.STORE_NAME_ALREADY_REGISTER);
    }

    Store emailToFind = storeRepository.getStoreByEmail(email);

    if (emailToFind != null) {
      throw new BusinessException("Ya existe el email ingresado", ErrorCodesEnum.STORE_EMAIL_ALREADY_REGISTER);
    }

    String passwordMD5 = EncrypterUtil.getMD5(password);
    Store store = new Store(name, owner, address, phone, email, passwordMD5);
    storeRepository.create(store);
  }

  /**
   * Service login store
   * @param email for login store
   * @param password for login store
   * @return true
   */
  public Boolean loginStore(String email, String password) {
    Store emailToFind = storeRepository.getStoreByEmail(email);

    if (emailToFind == null) {
      throw new BusinessException("email or password incorrect", ErrorCodesEnum.LOGIN_INCORRECT);
    }

    String passwordMD5 = EncrypterUtil.getMD5(password);

    if (!emailToFind.getPassword().equals(passwordMD5)) {
      throw new BusinessException("email or password incorrect", ErrorCodesEnum.LOGIN_INCORRECT);
    }
    return true;
  }

  /**
   * Service get all stores open
   * @return stores opes
   */
  public List<Store> getOpenStores() {
    return storeRepository.getAllStoresOpen();
  }

}
