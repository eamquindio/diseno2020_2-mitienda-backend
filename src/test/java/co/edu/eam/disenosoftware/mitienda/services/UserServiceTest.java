package co.edu.eam.disenosoftware.mitienda.services;

import co.edu.eam.disenosoftware.mitienda.exceptions.BusinessException;
import co.edu.eam.disenosoftware.mitienda.exceptions.ErrorCodesEnum;
import co.edu.eam.disenosoftware.mitienda.model.entities.User;
import co.edu.eam.disenosoftware.mitienda.repositories.UserRepository;
import co.edu.eam.disenosoftware.mitienda.utils.EncrypterUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
public class UserServiceTest {

  @Autowired
  private UserService service;

  @Autowired
  private UserRepository userRepository;

  @Test
  public void createUserTest() {
    service.createUser("pedro", "123", "pedrito", "1@1.com", "4567");
    User userToAssert = userRepository.find(1L);
    Assertions.assertNotNull(userToAssert);
    Assertions.assertEquals("pedrito", userToAssert.getUsername());
    Assertions.assertEquals(EncrypterUtil.getMD5("4567"), userToAssert.getPassword());

  }

  @Test
  @Sql({"/testdata/email_all_exist_test.sql"})
  public void emailAllExistTest() {
    BusinessException exception = Assertions.assertThrows(BusinessException.class, () -> service.createUser("pedro", "123", "pedrito", "email@hotmail.com", "1224"));
    Assertions.assertEquals(ErrorCodesEnum.EMAIL_ALREADY_EXIST, exception.getCode());
  }

  @Test
  @Sql({"/testdata/username_all_exist_test.sql"})
  public void usernameAllExistTest() {
    BusinessException exception = Assertions.assertThrows(BusinessException.class, () -> service.createUser("pedro", "123", "nombreusuario", "pedrito@hotmail.com", "1224"));
    Assertions.assertEquals(ErrorCodesEnum.USERNAME_ALREADY_EXIST, exception.getCode());
  }

  @Test
  @Sql({"/testdata/user_login_test.sql"})
  public void userLoginTest() {
    boolean loginToAssert = service.userLogin("nombreusuario", "12345");
    Assertions.assertEquals(true, loginToAssert);
  }

  @Test
  @Sql({"/testdata/user_wrong_test.sql"})
  public void userWrongTest() {
    BusinessException exception = Assertions.assertThrows(BusinessException.class, () -> service.userLogin("123", "12345"));
    Assertions.assertEquals(ErrorCodesEnum.USERNAME_IS_NOT_THE_SAME, exception.getCode());
  }

  @Test
  @Sql({"/testdata/password_wrong_test.sql"})
  public void passwordWrongTest() {
    BusinessException exception = Assertions.assertThrows(BusinessException.class, () -> service.userLogin("nombreusuario", "54321"));
    Assertions.assertEquals(ErrorCodesEnum.PASSWORD_IS_NOT_THE_SAME, exception.getCode());
  }
}
