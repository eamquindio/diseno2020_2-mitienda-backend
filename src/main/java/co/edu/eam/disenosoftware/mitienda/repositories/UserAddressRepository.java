package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.model.entities.UserAddress;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

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
   * Create a userAddress
   *
   * @param userAddress userAddress to create
   */
  public void create(UserAddress userAddress) {
    em.persist(userAddress);
  }

  /**
   * Find a userAddress by prime key
   *
   * @param id prime key
   * @return a userAddres or null if not exist
   */
  public UserAddress find(Long id) {
    UserAddress userAddress = em.find(UserAddress.class, id);
    return userAddress;
  }

  /**
   * Edit a userAddress
   *
   * @param userAddress userAddress to edit
   */
  public void edit(UserAddress userAddress) {
    em.merge(userAddress);
  }

  /**
   * delete a userAddress by prime key
   *
   * @param id userAddress to delete
   * @return userAddress userAddress to delete
   */
  public UserAddress delete(Long id) {
    UserAddress userAddress = find(id);
    if (userAddress != null) {
      em.remove(userAddress);
    }
    return userAddress;
  }

  /**
   * List all the users addresses
   *
   * @return list of users addreses
   */
  public List<UserAddress> getAllUsersAddresses() {
    String quertyStr = "SELECT userAddress FROM UserAddress userAddress";

    Query query = em.createQuery(quertyStr);

    return query.getResultList();
  }

}
