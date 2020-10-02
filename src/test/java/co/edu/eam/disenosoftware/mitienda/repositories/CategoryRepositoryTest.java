package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.model.entities.Category;
import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
public class CategoryRepositoryTest {

  @Autowired
  private CategoryRepository repository;

  @PersistenceContext
  private EntityManager em;

  @BeforeEach
  public void setup() {
    em.createQuery("delete from Category");
  }

  @Test
  public void test() {
    Assertions.assertTrue(true);
  }


  @Test
  @Sql({"/testdata/get_category_by_store_id.sql"})
  public void getCategoryByStoreIdTest(){
    List<Category>categories = repository.getCategoryByStoreId(1L);
    Assertions.assertEquals(1,categories.size());
  }

  @Test
  @Sql({"/testdata/get_category_by_store_id_and_name.sql"})
  public void getCategoryByStoreIdAndNameTest(){
    Category categoryToAssert = repository.getCategoryByStoreIdAndName(1L,"category1");
    Assertions.assertNotNull(categoryToAssert);
  }

}
