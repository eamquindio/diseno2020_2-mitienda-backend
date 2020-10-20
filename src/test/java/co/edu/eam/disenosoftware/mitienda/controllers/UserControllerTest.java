package co.edu.eam.disenosoftware.mitienda.controllers;

import co.edu.eam.disenosoftware.mitienda.exceptions.BusinessException;
import co.edu.eam.disenosoftware.mitienda.exceptions.ErrorCodesEnum;
import co.edu.eam.disenosoftware.mitienda.model.entities.User;
import co.edu.eam.disenosoftware.mitienda.model.responses.ErrorResponse;
import co.edu.eam.disenosoftware.mitienda.repositories.UserRepository;
import co.edu.eam.disenosoftware.mitienda.utils.EncrypterUtil;
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
    System.out.println(body);

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
    System.out.println(body);

    ErrorResponse error = objectMapper.readValue(body, ErrorResponse.class);
    Assertions.assertEquals("0020", error.getErrorCode());

  }

  @Test
  public void createUserTest() throws Exception {

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

    User user=userRepository.find(1L);
    Assertions.assertEquals(HttpStatus.OK.value(), status);
    System.out.println(body);

    Assertions.assertEquals("Pedro",user.getName());
  }

}
