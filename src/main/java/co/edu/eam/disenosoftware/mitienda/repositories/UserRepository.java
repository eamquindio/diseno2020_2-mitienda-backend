package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.model.entities.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

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
   * Create a user
   *
   * @param user user to Create.
   */
  public void create(User user) {
    em.persist(user);
  }

  /**
   * Find a user by primary key
   *
   * @param id primary key
   * @return a user or null if not exists
   */
  public User find(Long id) {
    return em.find(User.class, id);
  }

  /**
   * Edit a user
   *
   * @param user user to edit
   */
  public void edit(User user) {
    em.merge(user);
  }

  /**
   * Delete a user
   *
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

  /**
   * is numeric
   * @param cadena cadena
   * @return boolean
   */
  public boolean isNumeric(String cadena) {
    try {
      Long.parseLong(cadena);
      return true;
    } catch (NumberFormatException nfe) {
      return false;
    }
  }

  /**
   * Consulta que buscar User por Email
   *
   * @param email parametro para seleccionar usuarios por Email
   * @return list
   */
  public User getUserByEmail(String email) {
    String queryStr = "SELECT u FROM User u where u.email = :Reemail";
    Query query = em.createQuery(queryStr);
    query.setParameter("Reemail", email);

    List<User> list = query.getResultList();

    return list.isEmpty() ? null : list.get(0);
  }

  /**
   * Consulta que buscar User por Username
   *
   * @param username parametro para seleccionar usuarios por username
   * @return list
   */
  public User getUserByUserName(String username) {
    String queryStr = "SELECT u FROM User u where u.username = :username";
    Query query = em.createQuery(queryStr);
    query.setParameter("username", username);

    List<User> list = query.getResultList();

    return list.isEmpty() ? null : list.get(0);
  }
}
