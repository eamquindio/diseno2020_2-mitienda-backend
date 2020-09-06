package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.UserAddress;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Users address Repository
 */
@Component
@Transactional
public class UserAddressRepository {

  /**
   * EntityManager
   */
  @PersistenceContext
  private EntityManager em;

  /**
  *Create a userAddress
   *@param userAddress userAddress to create
   */
  public void create(UserAddress userAddress) {
    em.persist(userAddress);
  }

  /**
   * Find a userAddress by prime key
   * @param id prime key
   * @return a userAddres or null if not exist
   */
  public UserAddress find(Long id) {
    return em.find(UserAddress.class, id);
  }

  /**
   *  Edit a userAddress
   *  @param userAddress userAddress to edit
   */
  public void edit(UserAddress userAddress) {
    em.merge(userAddress);
  }

  /**
   * delete a userAddress by prime key
   * @param id userAddress to delete
   * @return userAddress userAddress to delete
   */
  public UserAddress delete(Long id) {
    UserAddress userAddress = find(id);
    em.remove(userAddress);
    return userAddress;
  }


}
