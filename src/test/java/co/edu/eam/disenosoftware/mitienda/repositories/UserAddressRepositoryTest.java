package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.model.entities.User;
import co.edu.eam.disenosoftware.mitienda.model.entities.UserAddress;
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
public class UserAddressRepositoryTest {

  @Autowired
  private UserAddressRepository userAddressRepository;

  @PersistenceContext
  private EntityManager em;

  @BeforeEach
  public void setup() {
    em.createQuery("delete from UserAddress");
  }

  @Test
  public void test() {
    Assertions.assertTrue(true);
  }

  /**
   * Test for createNotExistingUserAddress without a sql
   */
  @Test
  public void createNotExistingUserAddressTest() {
    //codigo probando Long id, String username
    User user = new User(1L, "Usuario 1");
    UserAddress userAddress = new UserAddress(1L, user, "Calle 13");
    em.persist(user);
    em.persist(userAddress);

    //codigo prueba
    userAddressRepository.create(userAddress);

    //resultado prueba
    UserAddress userAddressToAssert = userAddressRepository.find(1L);

    Assertions.assertNotNull(userAddressToAssert);
    Assertions.assertEquals(1L, userAddressToAssert.getId());
  }

  /**
   * Test for findExistingUserAddress with a sql
   */
  @Test
  @Sql({"/testdata/find_existing_address.sql"})
  public void findExistingUserAddressTest() {
    //codigo prueba
    UserAddress userAddressToAssert = userAddressRepository.find(2L);

    //resultado prueba
    Assertions.assertNotNull(userAddressToAssert);
    Assertions.assertEquals(2L, userAddressToAssert.getId());
  }

  /**
   * Test for findNotExistingAddress with a sql
   */
  @Test
  @Sql({"/testdata/find_not_existing_address.sql"})
  public void findNotExistingAddressTest() {
    //codigo prueba
    UserAddress userAddressToAssert = userAddressRepository.find(9L);

    //resultado prueba
    Assertions.assertNull(userAddressToAssert);
  }

  /**
   * Test for updateExistingUserAddress with a sql
   */
  @Test
  @Sql({"/testdata/update_existing_user_address.sql"})
  public void updateExistingUserAddressTest() {
    //codigo prueba
    UserAddress userAddress = userAddressRepository.find(1L);
    userAddress.setAddress("Nueva dirección");
    userAddressRepository.edit(userAddress);
    UserAddress userAddressToAssert = userAddressRepository.find(1L);

    //resultado prueba
    Assertions.assertNotNull(userAddressToAssert);
    Assertions.assertEquals("Nueva dirección", userAddressToAssert.getAddress());
  }

  /**
   * Test for deleteExistingUserAddress with a sql
   */
  @Test
  @Sql({"/testdata/delete_existing_user_address.sql"})
  public void deleteExistingUserAddressTest() {
    //codigo prueba
    UserAddress userAddress = userAddressRepository.find(1L);

    UserAddress deleteUserAddress = userAddressRepository.delete(1L);

    UserAddress userAddressToAssert = userAddressRepository.find(1L);

    //resultado prueba
    Assertions.assertNull(userAddressToAssert);
    Assertions.assertNotNull(deleteUserAddress);
    Assertions.assertEquals(userAddress, deleteUserAddress);
  }

  /**
   * Test for deleteNoExistingUserAddres with a sql
   */
  @Test
  @Sql({"/testdata/delete_not_existing_user_address.sql"})
  public void deleteNotExistingUserAddresTest() {
    //codigo prueba
    UserAddress userAddressToAssert = userAddressRepository.delete(3L);

    //resultado prueba
    Assertions.assertNull(userAddressToAssert);
  }

  /**
   * Test for getAllUsersAddresses with a sql
   */
  @Test
  @Sql({"/testdata/get_all_users_addresses.sql"})
  public void getAllUsersAddressesTest() {
    //codigo prueba
    List<UserAddress> usersAddresses = userAddressRepository.getAllUsersAddresses();

    //resultado prueba
    Assertions.assertEquals(5, usersAddresses.size());
  }

}
