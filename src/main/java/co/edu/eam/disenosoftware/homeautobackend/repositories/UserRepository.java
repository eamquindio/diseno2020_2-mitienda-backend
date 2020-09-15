package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * users Repository
 */
@Component
@Transactional
public class UserRepository {

  /**
   * EntityManager
   */
  @PersistenceContext
  private EntityManager em;

  /**
   * Create a room
   * @param user user to Create.
   */
  public void create(User user) {
    em.persist(user);
  }

  /**
   * Find a user by primary key
   * @param id primary key
   * @return a user or null if not exists
   */
  public User find(Long id) {
    return em.find(User.class, id);
  }

  /**
   * Edit a user
   * @param user user to edit
   */
  public void edit(User user) {
    em.merge(user);
  }

  /**
   * Delete a user
   * @param id primary key
   * @return user deleted or null if not exists
   */
  public User delete(Long id) {

    User user = find(id);

    if (user != null) {
      em.remove(user);
    }

    return user;
  }
}
