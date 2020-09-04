package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * User repository
 */
@Component
public class UserRepository {
  /**
   * Adding persistence context
   */
  @PersistenceContext
  private EntityManager en;

  /**
   * user
   * @param user , user
   */
  public void create(User user) {
    en.persist(user);
  }

  /**
   * user
   * @param id , id
   * @return , object
   */
  public User find(Long id) {
    return en.find(User.class, id);

  }

  /**
   * user
   * @param user , user
   */
  public void edit(User user) {
    en.merge(user);
  }

  /**
   * user
   * @param id , id
   * @return , object
   */
  public User delete(Long id) {
    User user = find(id);
    en.remove(user);
    return user;
  }
}
