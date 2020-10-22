package co.edu.eam.disenosoftware.mitienda.services;

import co.edu.eam.disenosoftware.mitienda.exceptions.BusinessException;
import co.edu.eam.disenosoftware.mitienda.exceptions.ErrorCodesEnum;
import co.edu.eam.disenosoftware.mitienda.model.entities.Category;
import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.repositories.CategoryRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Category service
 */
@Service
@Transactional
public class CategoryService {

  /**
   * Store Repository to find Store
   */
  @Autowired
  private StoreRepository repositoryStore;

  /**
   * Category Repository to find category name
   */
  @Autowired
  private CategoryRepository categoryRepository;

  /**
   * Method to create a category
   * @param icon param to set a icon
   * @param storeId param to find a store
   * @param name param to find and set a name to category
   */
  public void createCategory(String icon, Long storeId, String name) {
    Store store = repositoryStore.find(storeId);

    if (store == null) {

      throw new BusinessException("No se encontro la store", ErrorCodesEnum.NOT_FOUND_STORE);
    }
    Category category = categoryRepository.getCategoryByStoreIdAndName(storeId, name);

    if (category != null) {

      throw new BusinessException("El nombre de la category esta en uso", ErrorCodesEnum.NAME_CATEGORY_IN_USE);
    }
    Category newCategory = new Category(icon, name, store);
    categoryRepository.create(newCategory);
  }

  public List<Category> getAllCategoryByStoreId(Long id){
    Category category = categoryRepository.find(id);
    if(category == null){
      throw new BusinessException("No se encontro la categoria", ErrorCodesEnum.NOT_FOUND_CATEGORY);
    }
    return categoryRepository.getCategoryByStoreId(id);
  }
}

