package co.edu.eam.disenosoftware.mitienda.services;

import co.edu.eam.disenosoftware.mitienda.exceptions.BusinessException;
import co.edu.eam.disenosoftware.mitienda.exceptions.ErrorCodesEnum;
import co.edu.eam.disenosoftware.mitienda.model.entities.Category;
import co.edu.eam.disenosoftware.mitienda.repositories.CategoryRepository;
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
public class CategoryServiceTest {

  @Autowired
  private CategoryService service;

  @Autowired
  private CategoryRepository repository;

  @PersistenceContext
  private EntityManager em;

  @Test
  @Sql({"/testdata/create_category_not_found_store.sql"})
  public void createCategoryNotFoundStoreTest(){
    BusinessException exception = Assertions.assertThrows(BusinessException.class,
            () ->service.createCategory("hola.png",6L,"category1"));
    Assertions.assertEquals("No se encontro la store", exception.getMessage());
    Assertions.assertEquals(ErrorCodesEnum.NOT_FOUND_STORE, exception.getCode());
  }

  @Test
  @Sql({"/testdata/create_category_name_exist.sql"})
  public void createCategoryNameExistTest(){
    BusinessException exception = Assertions.assertThrows(BusinessException.class,
            () ->service.createCategory("hola.png",1L,"category1"));
    Assertions.assertEquals("El nombre de la category esta en uso", exception.getMessage());
    Assertions.assertEquals(ErrorCodesEnum.NAME_CATEGORY_IN_USE, exception.getCode());
  }

  @Test
  @Sql({"/testdata/create_category.sql"})
  public void createCategoryTest(){
    service.createCategory("hola.png",1L,"category2");
    List<Category> categoryTest= em.createQuery("SELECT category FROM Category category ").getResultList();
    Assertions.assertEquals(1,categoryTest.size());
  }
}
