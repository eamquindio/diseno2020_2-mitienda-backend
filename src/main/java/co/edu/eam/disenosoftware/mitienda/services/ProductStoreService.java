package co.edu.eam.disenosoftware.mitienda.services;

import co.edu.eam.disenosoftware.mitienda.exceptions.BusinessException;
import co.edu.eam.disenosoftware.mitienda.exceptions.ErrorCodesEnum;
import co.edu.eam.disenosoftware.mitienda.model.entities.Category;
import co.edu.eam.disenosoftware.mitienda.model.entities.Product;
import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.repositories.CategoryRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.ProductRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.ProductStoreRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ProductStoreService service
 */
@Service
@Transactional
public class ProductStoreService {

  /**
   * Product Repository to find product
   */
  @Autowired
  private ProductRepository repositoryProduct;
  /**
   * Store Repository to find Store
   */
  @Autowired
  private StoreRepository repositoryStore;

  /**
   * Category Repository to find category
   */
  @Autowired
  private CategoryRepository categoryRepository;

  /**
   * ProductStore Repository to create a product store
   */
  @Autowired
  private ProductStoreRepository repositoryProductStore;

  /**
   * Method to create a product
   * @param productId param to find a product
   * @param storeId param to find a store
   * @param categoryId param to find a category
   * @param stock param to set a stock to a product
   * @param price param to set a price to a product
   */
  public void createProduct(Long productId, Long storeId, Long categoryId, int stock, double price) {
    Product product = repositoryProduct.find(productId);

    if (product == null) {

      throw new BusinessException("No se encontro el product", ErrorCodesEnum.NOT_FOUND_PRODUCT);
    }
    Store store = repositoryStore.find(storeId);

    if (store == null) {

      throw new BusinessException("No se encontro la store", ErrorCodesEnum.NOT_FOUND_STORE);
    }
    Category category = categoryRepository.find(categoryId);

    if (category == null) {

      throw new BusinessException("No se encontro la category", ErrorCodesEnum.NOT_FOUND_CATEGORY);
    }
    ProductStore productStore = new ProductStore(product, stock, price, category, store);
    repositoryProductStore.create(productStore);
  }
}
