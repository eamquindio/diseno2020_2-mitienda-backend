package co.edu.eam.disenosoftware.homeautobackend.repositories;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.User;
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
  public void createNotExistingUserTest(){
    User user = new User(1L,"username");
    userRepository.create(user);

    User userToAssert = userRepository.find(1L);

    Assertions.assertNotNull(userToAssert);
    Assertions.assertEquals("username", userToAssert.getUsername());
  }

  @Test
  public void deleteExistingUserTest(){

    userRepository.create(new User(1L, "user1"));

    User deleteUser = userRepository.delete(1L);

    Assertions.assertNotNull(deleteUser);
    Assertions.assertEquals("user1", deleteUser.getUsername());

    User userToAssert = em.find(User.class, 1L);
    Assertions.assertNull(userToAssert);
  }

  @Test
  public void deleteNotExistingUser(){

    User deleteUser = userRepository.delete(1L);
    Assertions.assertNull(deleteUser);
  }

  @Test
  public void findExistingUserTest(){
    User user = new User(1L,"username");
    userRepository.create(user);

    User userToAssert = userRepository.find(1L);

    Assertions.assertNotNull(userToAssert);
    Assertions.assertEquals("username", userToAssert.getUsername());
  }

  @Test
  public void updateUserTest(){

    User user = new User(1L,"username");
    userRepository.create(new User(1L, "username"));

    user.setName("pedro");
    userRepository.edit(user);

    User userToAssert = userRepository.find(1L);
    Assertions.assertEquals("pedro", userToAssert.getName());
  }

}
