package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@SpringBootTest
public class StoreRepositoryTest {

  @Autowired
  private StoreRepository storeRepository;

  @PersistenceContext
  private EntityManager em;

  @Test
  public void createNotExistingStoreTest(){
    storeRepository.create(new Store(1L,"Tiendita1"));

    Store storeToAssert = storeRepository.find(1L);

    Assertions.assertNotNull(storeToAssert);
    Assertions.assertEquals("Tiendita1", storeToAssert.getName());
  }

  @Test
  public void deleteExistingStoreTest(){
    storeRepository.create(new Store(1L,"Tiendita1"));

    Store deletedStore = storeRepository.delete(1L);

    Assertions.assertNotNull(deletedStore);
    Assertions.assertEquals("Tiendita1", deletedStore.getName());

    Store storeToAssert = storeRepository.find(1L);
    Assertions.assertNull(storeToAssert);
  }

  @Test
  public void deleteNotExistingStoreTest(){
    Store deletedStore = storeRepository.delete(1L);
    Assertions.assertNull(deletedStore);
  }

  @Test
  public void findExistingStoreTest(){
    storeRepository.create(new Store(1L,"Tiendita1"));

    Store storeToAssert = storeRepository.find(1L);

    Assertions.assertNotNull(storeToAssert);
    Assertions.assertEquals("Tiendita1", storeToAssert.getName());
  }

  @Test
  public void findNotExistingStoreTest(){
    Store storeToAssert = storeRepository.find(1L);
    Assertions.assertNull(storeToAssert);
  }

  @Test
  public void updateStoreTest(){
    Store store = new Store(1L,"Tiendita1");
    storeRepository.create(store);

    store.setName("TiendaUno");
    storeRepository.edit(store);

    Store storeToAssert = storeRepository.find(1L);
    Assertions.assertEquals("TiendaUno", storeToAssert.getName());
  }

  @BeforeEach
  public void setup() {
    em.createQuery("delete from Store");
  }

  @Test
  public void test() {
    Assertions.assertTrue(true);
  }

}
