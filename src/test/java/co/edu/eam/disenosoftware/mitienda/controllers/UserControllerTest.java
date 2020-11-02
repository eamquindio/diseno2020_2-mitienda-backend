package co.edu.eam.disenosoftware.mitienda.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.User;
import co.edu.eam.disenosoftware.mitienda.model.responses.ErrorResponse;
import co.edu.eam.disenosoftware.mitienda.repositories.UserRepository;
import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.repositories.OrderRepository;
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
import javax.swing.text.html.parser.Entity;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private OrderService orderService;

  @Autowired
  private OrderRepository orderRepository;

  @Test
  @Sql({"/testdata/username_all_exist_api.sql"})
  public void usernameAllExistTest() throws Exception {

    String jsonBody = "{\n" +
            "    \"name\":\"Pedro\",\n" +
            "    \"phone\": \"3105093214\",\n" +
            "    \"username\": \"gato\",\n" +
            "    \"email\":\"jose@gmail.com\",\n" +
            "    \"password\":\"1123\"\n" +
            "}\n";
    RequestBuilder request = MockMvcRequestBuilders.post("/api/users/register")
            .contentType("application/json")
            .content(jsonBody);

    //2. hacer la peticion
    ResultActions result = mockMvc.perform(request);

    //3. sacar los resultados de la peticion
    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    //4. hacer las asersion
    Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED.value(), status);

    ErrorResponse error = objectMapper.readValue(body, ErrorResponse.class);
    Assertions.assertEquals("0021", error.getErrorCode());
  }

  @Test
  @Sql({"/testdata/email_all_exist_api.sql"})
  public void emailAllExistTest() throws Exception {

    String jsonBody = "{\n" +
            "    \"name\":\"Pedro\",\n" +
            "    \"phone\": \"3105093214\",\n" +
            "    \"username\": \"Joselito\",\n" +
            "    \"email\":\"jose@gmail.com\",\n" +
            "    \"password\":\"1123\"\n" +
            "}\n";
    RequestBuilder request = MockMvcRequestBuilders.post("/api/users/register")
            .contentType("application/json")
            .content(jsonBody);

    //2. hacer la peticion
    ResultActions result = mockMvc.perform(request);

    //3. sacar los resultados de la peticion
    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    //4. hacer las asersion
    Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED.value(), status);

    ErrorResponse error = objectMapper.readValue(body, ErrorResponse.class);
    Assertions.assertEquals("0020", error.getErrorCode());

  }

  @Test
  public void createUserTest() throws Exception {

    String jsonBody = "{\n" +
            "    \"name\":\"pedro\",\n" +
            "    \"phone\": \"3185757311\",\n" +
            "    \"username\": \"pedrito\",\n" +
            "    \"email\":\"pedrito@gmail.com\",\n" +
            "    \"password\":\"4567\"\n" +
            "}\n";
    RequestBuilder request = MockMvcRequestBuilders.post("/api/users/register")
            .contentType("application/json")
            .content(jsonBody);

    //2. hacer la peticion
    ResultActions result = mockMvc.perform(request);

    //3. sacar los resultados de la peticion
    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    //4. hacer las asersion

    User user=userRepository.find(1L);
    Assertions.assertEquals(HttpStatus.OK.value(), status);

    Assertions.assertEquals("pedro",user.getName());
  }

  @Test
  @Sql({"/testdata/controllers/controller_user_login_test.sql"})
  public void controllerUserLoginTest() throws Exception{
    String jsonBody = "{\n" +
            "    \"username\": \"nombreusuario\",\n" +
            "    \"password\": \"12345\"\n" +
            "}";
    RequestBuilder request = MockMvcRequestBuilders.post("/api/users/login")
            .contentType("application/json")
            .content(jsonBody);

    ResultActions result = mockMvc.perform(request);

    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    User user = objectMapper.readValue(body, User.class);

    Assertions.assertEquals(HttpStatus.OK.value(), status);
    Assertions.assertEquals("nombreusuario",user.getUsername());
  }

  @Test
  @Sql({"/testdata/controllers/controller_user_login_wrong_username_test.sql"})
  public void controllerUserLoginWrongUsernameTest() throws Exception{
    String jsonBody = "{\n" +
            "    \"username\": \"nombreusuarioo\",\n" +
            "    \"password\": \"12345\"\n" +
            "}";
    RequestBuilder request = MockMvcRequestBuilders.post("/api/users/login")
            .contentType("application/json")
            .content(jsonBody);

    ResultActions result = mockMvc.perform(request);

    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    Assertions.assertEquals(HttpStatus.FORBIDDEN.value(), status);

    ErrorResponse error = objectMapper.readValue(body, ErrorResponse.class);
    Assertions.assertEquals("0019", error.getErrorCode());
  }

  @Test
  @Sql({"/testdata/controllers/controller_user_login_wrong_password_test.sql"})
  public void controllerUserLoginWrongPasswordTest() throws Exception{
    String jsonBody = "{\n" +
            "    \"username\": \"nombreusuario\",\n" +
            "    \"password\": \"123456\"\n" +
            "}";
    RequestBuilder request = MockMvcRequestBuilders.post("/api/users/login")
            .contentType("application/json")
            .content(jsonBody);

    ResultActions result = mockMvc.perform(request);

    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    Assertions.assertEquals(HttpStatus.FORBIDDEN.value(), status);

    ErrorResponse error = objectMapper.readValue(body, ErrorResponse.class);
    Assertions.assertEquals("0019", error.getErrorCode());
  }

  @Test
  @Sql({"/testdata/controllers/orders_by_user_id.sql"})
  public void ordersByUserIdTest() throws Exception {
    //1. crear la peticion
    RequestBuilder request = MockMvcRequestBuilders.get("/api/users/1/orders");
    //2. hacer la peticion
    ResultActions result = mockMvc.perform(request);

    //3. sacar los resultados de la peticion
    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();
    //4. hacer las asersion
    Assertions.assertEquals(HttpStatus.OK.value(), status);
    Order[] orders = objectMapper.readValue(body,Order[].class);

    Assertions.assertEquals(2, orders.length);
  }
}
