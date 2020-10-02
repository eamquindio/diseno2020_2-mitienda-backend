package co.edu.eam.disenosoftware.mitienda.services;

import co.edu.eam.disenosoftware.mitienda.exceptions.BusinessException;
import co.edu.eam.disenosoftware.mitienda.exceptions.ErrorCodesEnum;
import co.edu.eam.disenosoftware.mitienda.model.entities.Category;
import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@SpringBootTest
public class ProductStoreServiceTest {

  @Autowired
  private ProductStoreService service;

  @PersistenceContext
  private EntityManager em;

  @Test
  @Sql({"/testdata/create_product_not_found_product.sql"})
  public void createProductNotFoundProductTest(){
    BusinessException exception = Assertions.assertThrows(BusinessException.class,
            () ->service.createProduct(6L, 1L, 2L, 15, 2000));
    Assertions.assertEquals("No se encontro el product", exception.getMessage());
    Assertions.assertEquals(ErrorCodesEnum.NOT_FOUND_PRODUCT, exception.getCode());
  }

  @Test
  @Sql({"/testdata/create_product_not_found_store.sql"})
  public void createProductNotFoundStoreTest(){
    BusinessException exception = Assertions.assertThrows(BusinessException.class,
            () ->service.createProduct(3L, 6L, 2L, 15, 2000));
    Assertions.assertEquals("No se encontro la store", exception.getMessage());
    Assertions.assertEquals(ErrorCodesEnum.NOT_FOUND_STORE, exception.getCode());
  }

  @Test
  @Sql({"/testdata/create_product_not_found_category.sql"})
  public void createProductNotFoundCategoryTest(){
    BusinessException exception = Assertions.assertThrows(BusinessException.class,
            () ->service.createProduct(3L, 1L, 6L, 15, 2000));
    Assertions.assertEquals("No se encontro la category", exception.getMessage());
    Assertions.assertEquals(ErrorCodesEnum.NOT_FOUND_CATEGORY, exception.getCode());
  }

  @Test
  @Sql({"/testdata/create_product.sql"})
  public void createProduct(){
    service.createProduct(3L, 1L, 2L, 15, 2000);
    List<ProductStore> productStores= em.createQuery("SELECT productStore FROM ProductStore productStore ").getResultList();
    Assertions.assertEquals(1,productStores.size());
  }
}
