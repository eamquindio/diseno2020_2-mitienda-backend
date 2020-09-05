package co.edu.eam.disenosoftware.homeautobackend.repositories;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * shopping cart Repository
 */
@Component
@Transactional
public class ShoppingCartRepository {

  /**
   * EntityManager
   */
  @PersistenceContext
  private EntityManager em;
}
