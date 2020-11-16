package co.edu.eam.disenosoftware.mitienda.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.Category;
import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.model.responses.ErrorResponse;
import co.edu.eam.disenosoftware.mitienda.repositories.OrderRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.StoreRepository;
import co.edu.eam.disenosoftware.mitienda.services.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class StoresControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private StoreRepository storeRepository;

  @Autowired
  private OrderService orderService;

  @Autowired
  private OrderRepository orderRepository;

  @Test
  @Sql("/testdata/controllers/get_all_stores_open.sql")
  public void getAllStoresOpenTest () throws Exception {
    RequestBuilder request = MockMvcRequestBuilders.get("/api/stores/is-open");

    ResultActions result = mockMvc.perform(request);
    String body = result.andReturn().getResponse().getContentAsString();

    int numberStatus = result.andReturn().getResponse().getStatus();

    Store[] storesToAssert = objectMapper.readValue(body,Store[].class);

    Assertions.assertEquals(200,numberStatus);
    Assertions.assertEquals(3,storesToAssert.length);
    Assertions.assertEquals("la tiendita1",storesToAssert[0].getName());
    Assertions.assertEquals("la tiendita2",storesToAssert[1].getName());
    Assertions.assertEquals("la tiendita3",storesToAssert[2].getName());
  }

  @Test
  @Sql({"/testdata/controllers/orders_by_store_id.sql"})
  public void ordersByStoreIdTest() throws Exception {
    RequestBuilder request = MockMvcRequestBuilders.get("/api/stores/1/orders");

    ResultActions result = mockMvc.perform(request);

    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    Assertions.assertEquals(HttpStatus.OK.value(), status);
    Order[] orders = objectMapper.readValue(body,Order[].class);

    Assertions.assertEquals(3, orders.length);
  }

  @PersistenceContext
  private EntityManager em;

  @Test
  @Sql("/testdata/controlles_get_all_category_store_by_store_id.sql")
  public void getAllCategoryByStoreId() throws Exception{

    RequestBuilder request = MockMvcRequestBuilders.get("/api/stores/3/categories");

    ResultActions result = mockMvc.perform((request));

    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    Assertions.assertEquals(200,status);

    Category[] category = objectMapper.readValue(body, Category[].class);
    Assertions.assertEquals(1, category.length);
  }

  @Test
  @Sql({"/testdata/controllers/controller_store_login_test.sql"})
  public void controllerStoreLoginTest() throws Exception{
    String jsonBody = "{\n" +
        "    \"email\": \"tienda@gmail.com\",\n" +
        "    \"password\": \"1234\"\n" +
        "}";
    RequestBuilder request = MockMvcRequestBuilders.post("/api/stores/login")
        .contentType("application/json")
        .content(jsonBody);

    ResultActions result = mockMvc.perform(request);

    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    Store storeToAssert = objectMapper.readValue(body,Store.class);

    Assertions.assertEquals(HttpStatus.OK.value(), status);
    Assertions.assertEquals("cra 12",storeToAssert.getAddress());
    Assertions.assertEquals("Pepito",storeToAssert.getOwner());
  }

  @Test
  @Sql({"/testdata/controllers/controller_store_login_wrong_email_test.sql"})
  public void controllerStoreLoginWrongEmailTest() throws Exception{
    String jsonBody = "{\n" +
        "    \"email\": \"ti@gmail.com\",\n" +
        "    \"password\": \"1234\"\n" +
        "}";
    RequestBuilder request = MockMvcRequestBuilders.post("/api/stores/login")
        .contentType("application/json")
        .content(jsonBody);

    ResultActions result = mockMvc.perform(request);

    int status = result.andReturn().getResponse().getStatus();

    Assertions.assertEquals(403, status);
  }

  @Test
  @Sql({"/testdata/controllers/controller_store_login_wrong_password_test.sql"})
  public void controllerUserLoginWrongPasswordTest() throws Exception{
    String jsonBody = "{\n" +
        "    \"email\": \"tienda@gmail.com\",\n" +
        "    \"password\": \"123\"\n" +
        "}";
    RequestBuilder request = MockMvcRequestBuilders.post("/api/stores/login")
            .contentType("application/json")
            .content(jsonBody);

    ResultActions result = mockMvc.perform(request);

    int status = result.andReturn().getResponse().getStatus();

    Assertions.assertEquals(403, status);
  }

  @Test
  public void controllerCreateStoreTest() throws Exception {

    String jsonBody = "{\n" +
            "    \"name\":\"Store potatoes\",\n" +
            "    \"owner\": \"Sara Lucia Carmona Cuartas\",\n" +
            "    \"address\": \"Dirección x\",\n" +
            "    \"phone\":\"3105402020\",\n" +
            "    \"email\":\"sara@gmail.com\",\n" +
            "    \"password\":\"123\"\n" +
            "}\n";
    RequestBuilder request = MockMvcRequestBuilders.post("/api/stores/register")
            .contentType("application/json")
            .content(jsonBody);

    ResultActions result = mockMvc.perform(request);
    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    Store store = storeRepository.find(4L);

    Assertions.assertEquals(HttpStatus.OK.value(), status);

    Assertions.assertEquals("Sara Lucia Carmona Cuartas", store.getOwner());
  }

  @Test
  @Sql({"/testdata/controllers/register_store_name_in_use_api.sql"})
  public void controllerCreateStoreWhenNameIsInUseTest() throws Exception {
    String jsonBody = "{\n" +
            "    \"name\":\"Store potatoes\",\n" +
            "    \"owner\": \"Sara Lucia Carmona Cuartas\",\n" +
            "    \"address\": \"Dirección x\",\n" +
            "    \"phone\":\"3105402020\",\n" +
            "    \"email\":\"sara@gmail.com\",\n" +
            "    \"password\":\"123\"\n" +
            "}\n";
    RequestBuilder request = MockMvcRequestBuilders.post("/api/stores/register")
            .contentType("application/json")
            .content(jsonBody);

    ResultActions result = mockMvc.perform(request);

    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED.value(), status);

    ErrorResponse error = objectMapper.readValue(body, ErrorResponse.class);
    Assertions.assertEquals("0017", error.getErrorCode());
  }

  @Test
  @Sql({"/testdata/controllers/register_store_email_in_use_api.sql"})
  public void controllerCreateStoreWhenEmailIsInUseTest() throws Exception {
    String jsonBody = "{\n" +
            "    \"name\":\"Store potatoes\",\n" +
            "    \"owner\": \"Sara Lucia Carmona Cuartas\",\n" +
            "    \"address\": \"Dirección x\",\n" +
            "    \"phone\":\"3105402020\",\n" +
            "    \"email\":\"sara@gmail.com\",\n" +
            "    \"password\":\"123\"\n" +
            "}\n";
    RequestBuilder request = MockMvcRequestBuilders.post("/api/stores/register")
            .contentType("application/json")
            .content(jsonBody);

    ResultActions result = mockMvc.perform(request);

    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED.value(), status);

    ErrorResponse error = objectMapper.readValue(body, ErrorResponse.class);
    Assertions.assertEquals("0018", error.getErrorCode());
  }

  @Test
  public void controllerCreateStoreWhenEmailIsIncorrectTest() throws Exception {
    String jsonBody = "{\n" +
            "    \"name\":\"Store potatooes\",\n" +
            "    \"owner\": \"Sara Lucia Carmona Cuartas\",\n" +
            "    \"address\": \"Dirección x\",\n" +
            "    \"phone\":\"3105402020\",\n" +
            "    \"email\":\"@sara@gmail.com\",\n" +
            "    \"password\":\"123\"\n" +
            "}\n";
    RequestBuilder request = MockMvcRequestBuilders.post("/api/stores/register")
            .contentType("application/json")
            .content(jsonBody);

    ResultActions result = mockMvc.perform(request);

    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED.value(), status);

    ErrorResponse error = objectMapper.readValue(body, ErrorResponse.class);
    Assertions.assertEquals("0031", error.getErrorCode());
  }

  @Test
  public void controllerCreateStoreWhenPhoneNumberIsIncorrectTest() throws Exception {
    String jsonBody = "{\n" +
            "    \"name\":\"Store potatooes\",\n" +
            "    \"owner\": \"Sara Lucia Carmona Cuartas\",\n" +
            "    \"address\": \"Dirección x\",\n" +
            "    \"phone\":\"phone\",\n" +
            "    \"email\":\"sara@gmail.com\",\n" +
            "    \"password\":\"123\"\n" +
            "}\n";
    RequestBuilder request = MockMvcRequestBuilders.post("/api/stores/register")
            .contentType("application/json")
            .content(jsonBody);

    ResultActions result = mockMvc.perform(request);

    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED.value(), status);

    ErrorResponse error = objectMapper.readValue(body, ErrorResponse.class);
    Assertions.assertEquals("0031", error.getErrorCode());
  }
}
