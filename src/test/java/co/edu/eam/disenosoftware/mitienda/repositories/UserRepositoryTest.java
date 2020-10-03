package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.model.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@SpringBootTest
public class UserRepositoryTest {

  @Autowired
  private UserRepository userRepository;

  @PersistenceContext
  private EntityManager em;

  @BeforeEach
  public void setup() {
    em.createQuery("delete from User");
  }

  @Test
  public void test() {
    Assertions.assertTrue(true);
  }

  @Test
  @Sql({"/testdata/create_not_existing_user_test.sql"})
  public void createNotExistingUserTest(){

    User userToAssert = userRepository.find(1L);

    Assertions.assertNotNull(userToAssert);
    Assertions.assertEquals("nombreusuario", userToAssert.getUsername());
  }

  @Test
  @Sql({"/testdata/delete_existing_user_test.sql"})
  public void deleteExistingUserTest(){

    User deleteUser = userRepository.delete(1L);

    Assertions.assertNotNull(deleteUser);
    Assertions.assertEquals("nombreusuario", deleteUser.getUsername());

    User userToAssert = em.find(User.class, 1L);
    Assertions.assertNull(userToAssert);
  }

  @Test
  public void deleteNotExistingUser(){

    User deleteUser = userRepository.delete(1L);
    Assertions.assertNull(deleteUser);
  }

  @Test
  @Sql({"/testdata/find_existing_user_test.sql"})
  public void findExistingUserTest(){

    User userToAssert = userRepository.find(1L);

    Assertions.assertNotNull(userToAssert);
    Assertions.assertEquals("nombreusuario", userToAssert.getUsername());
  }

  @Test
  @Sql({"/testdata/update_user_test.sql"})
  public void updateUserTest(){

    User userToAssert = userRepository.find(1L);
    userToAssert.setName("pedro");

    Assertions.assertEquals("pedro", userToAssert.getName());
  }

}
