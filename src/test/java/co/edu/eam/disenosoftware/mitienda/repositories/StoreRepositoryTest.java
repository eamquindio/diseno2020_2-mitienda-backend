package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
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

  @Test
  public void testForGetAllStores() {
    Store storeA = new Store(1L,"first");
    Store storeB = new Store(2L,"second");
    em.persist(storeA);
    em.persist(storeB);
    List<Store> storeTest = storeRepository.getAllStores();
    Assertions.assertEquals(2, storeTest.size());
  }

  @Test
  public void getStoreByEmailTest(){
    Store store = new Store(1L,"tienda1@gmail.com","tienda1");
    storeRepository.create(store);
    Store storeToAssert = storeRepository.getStoreByEmail("tienda1@gmail.com");
    Assertions.assertEquals("tienda1@gmail.com",storeToAssert.getEmail());
  }

}