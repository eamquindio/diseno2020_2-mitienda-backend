package co.edu.eam.disenosoftware.homeautobackend.repositories;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * OrderProduct Repository
 */
@Component
@Transactional
public class OrderProductRepository {

  /**
   * EntityManager
   */
  @PersistenceContext
  private EntityManager em;
}
