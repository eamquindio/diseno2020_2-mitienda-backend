package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.Category;
import co.edu.eam.disenosoftware.homeautobackend.model.entities.ProductStore;
import co.edu.eam.disenosoftware.homeautobackend.model.entities.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
  public void getCategoryByStoreIdTest(){

  Store store= new Store(1L);
    Store store2= new Store(2L);

    em.persist(store);
    em.persist(store2);

    Category category1=new Category(1L,store);
    Category category2=new Category(2L,store2);
    Category category3=new Category(3L,store);
    Category category4=new Category(4L,store);

    em.persist(category1);
    em.persist(category2);
    em.persist(category3);
    em.persist(category4);

    List<Category> categories = repository.getCategoryByStoreId(1L);

    Assertions.assertEquals(3, categories.size());

  }

}
