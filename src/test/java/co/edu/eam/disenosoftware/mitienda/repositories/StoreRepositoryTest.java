package co.edu.eam.disenosoftware.mitienda.repositories;

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
public class StoreRepositoryTest {

  @Autowired
  private StoreRepository storeRepository;

  @PersistenceContext
  private EntityManager em;

  @BeforeEach
  public void setup() {
    em.createQuery("delete from Store");
  }

  @Test
  public void test() {
    Assertions.assertTrue(true);
  }

  @Test
  @Sql({"/testdata/create_not_existing_store.sql"})
  public void createNotExistingStoreTest(){
    List<Store> stores = em.createQuery("SELECT s FROM Store s").getResultList();
    Store storeToAssert = stores.get(stores.size()-1);

    Assertions.assertNotNull(storeToAssert);
    Assertions.assertEquals("store1", storeToAssert.getName());
  }

  @Test
  @Sql({"/testdata/delete_existing_store.sql"})
  public void deleteExistingStoreTest(){
    Store deletedStore = storeRepository.delete(1L);

    Assertions.assertNotNull(deletedStore);
    Assertions.assertEquals("store1", deletedStore.getName());

    Store storeToAssert = storeRepository.find(1L);
    Assertions.assertNull(storeToAssert);
  }

  @Test
  public void deleteNotExistingStoreTest(){
    Store deletedStore = storeRepository.delete(1L);
    Assertions.assertNull(deletedStore);
  }

  @Test
  @Sql({"/testdata/find_existing_store.sql"})
  public void findExistingStoreTest(){
    Store storeToAssert = storeRepository.find(1L);

    Assertions.assertNotNull(storeToAssert);
    Assertions.assertEquals("store1", storeToAssert.getName());
  }

  @Test
  public void findNotExistingStoreTest(){
    Store storeToAssert = storeRepository.find(1L);
    Assertions.assertNull(storeToAssert);
  }

  @Test
  @Sql({"/testdata/update_store.sql"})
  public void updateStoreTest(){
    List<Store> stores = em.createQuery("SELECT s FROM Store s").getResultList();
    Store store = stores.get(stores.size()-1);
    store.setName("TiendaUno");
    storeRepository.edit(store);
    Store storeToAssert = storeRepository.find(1L);
    Assertions.assertEquals("TiendaUno", storeToAssert.getName());
  }

  @Test
  @Sql({"/testdata/test_for_get_all_store.sql"})
  public void testForGetAllStores() {
    List<Store> storeTest = storeRepository.getAllStores();
    Assertions.assertEquals(2, storeTest.size());
  }

  @Test
  @Sql({"/testdata/get_store_by_email.sql"})
  public void getStoreByEmailTest(){
    Store storeToAssert = storeRepository.getStoreByEmail("store@gmail.com");
    Assertions.assertEquals("store@gmail.com",storeToAssert.getEmail());
  }

  @Test
  @Sql({"/testdata/get_store_by_email.sql"})
  public void getStoreByNameTest(){
    Store storeToAssert = storeRepository.getStoreByName("store1");
    Assertions.assertEquals("store1",storeToAssert.getName());
  }

  @Test
  @Sql({"/testdata/get_all_stores_open.sql"})
  public void getAllStoresOpenTest () {
    List<Store> storesToAssert = storeRepository.getAllStoresOpen();
    Assertions.assertEquals(2,storesToAssert.size());
  }

  @Test
  public void getAllStoresNotOpenTest () {
    List<Store> storesToAssert = storeRepository.getAllStoresOpen();
    Assertions.assertEquals(0,storesToAssert.size());
  }

}
