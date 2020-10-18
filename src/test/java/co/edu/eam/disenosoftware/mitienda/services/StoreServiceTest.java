package co.edu.eam.disenosoftware.mitienda.services;

import co.edu.eam.disenosoftware.mitienda.exceptions.BusinessException;
import co.edu.eam.disenosoftware.mitienda.exceptions.ErrorCodesEnum;
import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
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
public class StoreServiceTest {

  @Autowired
  private StoreService service;

  @PersistenceContext
  private EntityManager em;

  @Test
  @Sql({"/testdata/register_store_name_in_use.sql"})
  public void registerStoreNameInUse() {
    BusinessException exception = Assertions.assertThrows(BusinessException.class,
            () ->service.registerStore("store1","a", "s", "phone", "store123@gmail.com", "dae"));
    Assertions.assertEquals("Ya existe el nombre ingresado", exception.getMessage());
    Assertions.assertEquals(ErrorCodesEnum.STORE_NAME_ALREADY_REGISTER, exception.getCode());
  }

  @Test
  @Sql({"/testdata/register_store_email_in_use.sql"})
  public void registerStoreEmailInUse() {
    BusinessException exception = Assertions.assertThrows(BusinessException.class,
            () ->service.registerStore("store","a", "s", "phone", "store@gmail.com", "dae"));
    Assertions.assertEquals("Ya existe el email ingresado", exception.getMessage());
    Assertions.assertEquals(ErrorCodesEnum.STORE_EMAIL_ALREADY_REGISTER, exception.getCode());
  }

  @Test
  public void registerStoreSuccessful() {
    service.registerStore("store","a", "s", "phone", "store@gmail.com", "1234");
    Store store = em.find(Store.class, 1L);
    Assertions.assertEquals("81dc9bdb52d04dc20036dbd8313ed055",store.getPassword());
    Assertions.assertNotNull(store);
    Assertions.assertEquals("store", store.getName());
  }

  @Test
  @Sql({"/testdata/register_store_not_null_email.sql"})
  public void loginStoreNotNullEmail() {
    BusinessException exception = Assertions.assertThrows(BusinessException.class,
            () ->service.loginStore("store@gmail.com", "321"));
    Assertions.assertEquals("email or password incorrect", exception.getMessage());
    Assertions.assertEquals(ErrorCodesEnum.LOGIN_INCORRECT, exception.getCode());
  }

  @Test
  @Sql({"/testdata/register_store_incorrect_password.sql"})
  public void loginStoreIncorrectPassword() {
    BusinessException exception = Assertions.assertThrows(BusinessException.class,
            () ->service.loginStore("store@gmail.com", "321"));
    Assertions.assertEquals("email or password incorrect", exception.getMessage());
    Assertions.assertEquals(ErrorCodesEnum.LOGIN_INCORRECT, exception.getCode());
  }

  @Test
  @Sql({"/testdata/login_store_successful.sql"})
  public void loginStoreSuccessful() {
    boolean successful = service.loginStore("store@gmail.com", "1234");
    Assertions.assertEquals(true, successful);
  }

  @Test
  @Sql({"/testdata/get_all_stores_open.sql"})
  public void getAllStoresOpenTest () {
    List<Store> storesToAssert = service.bringStoresOpen();
    Assertions.assertEquals(2,storesToAssert.size());
  }
}
