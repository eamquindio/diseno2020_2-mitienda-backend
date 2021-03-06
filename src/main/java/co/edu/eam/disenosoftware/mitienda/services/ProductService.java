package co.edu.eam.disenosoftware.mitienda.services;

import co.edu.eam.disenosoftware.mitienda.model.entities.Product;
import co.edu.eam.disenosoftware.mitienda.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ProductService service
 */
@Service
@Transactional
public class ProductService {

  /**
   * Autowired
   */
  @Autowired
  private ProductRepository productRepository;

  /**
   * GetAallProductByName
   *
   * @param name , name
   * @return List product
   */

  public List<Product> getAllProductByName(String name) {
    return productRepository.getProductsByName(name);
  }
}
