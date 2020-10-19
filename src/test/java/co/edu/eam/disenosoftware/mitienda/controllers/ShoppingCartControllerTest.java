package co.edu.eam.disenosoftware.mitienda.controllers;


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
public class ShoppingCartControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @PersistenceContext
  private EntityManager em;

  @Test
  @Sql({"/testdata/controller_create_shopping_cart_product_test.sql"})
  public void createShoppingCartProduct() throws Exception{

    String jSonBody = "{\n" +
            "\"storeId\":2,\n" +
            "\"userId\":3,\n" +
            "\"productId\":4,\n" +
            "\"quantity\":2\n" +
            "}";

    RequestBuilder request = MockMvcRequestBuilders.post("/api/shopping-cart/add-product")
            .contentType("application/json")
            .content(jSonBody);

    ResultActions result = mockMvc.perform(request);

    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();


    Assertions.assertEquals(HttpStatus.OK.value(),status);

    System.out.println(body);

  }

  @Test
  @Sql({"/testdata/controller_not_existing_shopping_cart_product_test.sql"})
  public void notExistingShoppingCartTest() throws Exception{

    String jSonBody = "{\n" +
            "\"storeId\":2,\n" +
            "\"userId\":3,\n" +
            "\"productId\":4,\n" +
            "\"quantity\":2\n" +
            "}";

    RequestBuilder request = MockMvcRequestBuilders.post("/api/shopping-cart/add-product")
            .contentType("application/json")
            .content(jSonBody);

    ResultActions result = mockMvc.perform(request);

    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();


    Assertions.assertEquals(HttpStatus.OK.value(),status);

    System.out.println(body);

  }

  @Test
  @Sql({"/testdata/controller_product_store_does_not_exist_test.sql"})
  public void productStoreDoesNotExistTest() throws Exception{

    String jSonBody = "{\n" +
            "\"storeId\":2,\n" +
            "\"userId\":3,\n" +
            "\"productId\":4,\n" +
            "\"quantity\":2\n" +
            "}";

    RequestBuilder request = MockMvcRequestBuilders.post("/api/shopping-cart/add-product")
            .contentType("application/json")
            .content(jSonBody);

    ResultActions result = mockMvc.perform(request);

    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();


    Assertions.assertEquals(HttpStatus.NOT_FOUND.value(),status);

    System.out.println(body);

  }

  @Test
  @Sql({"/testdata/controller_user_does_not_exist_test.sql"})
  public void userDoesNotExistTest() throws Exception{

    String jSonBody = "{\n" +
            "\"storeId\":2,\n" +
            "\"userId\":3,\n" +
            "\"productId\":4,\n" +
            "\"quantity\":2\n" +
            "}";

    RequestBuilder request = MockMvcRequestBuilders.post("/api/shopping-cart/add-product")
            .contentType("application/json")
            .content(jSonBody);

    ResultActions result = mockMvc.perform(request);

    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();


    Assertions.assertEquals(HttpStatus.NOT_FOUND.value(),status);

    System.out.println(body);

  }

  @Test
  @Sql({"/testdata/controller_store_does_not_exist_test.sql"})
  public void storeDoesNotExistTest() throws Exception{

    String jSonBody = "{\n" +
            "\"storeId\":2,\n" +
            "\"userId\":3,\n" +
            "\"productId\":4,\n" +
            "\"quantity\":2\n" +
            "}";

    RequestBuilder request = MockMvcRequestBuilders.post("/api/shopping-cart/add-product")
            .contentType("application/json")
            .content(jSonBody);

    ResultActions result = mockMvc.perform(request);

    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();


    Assertions.assertEquals(HttpStatus.NOT_FOUND.value(),status);

    System.out.println(body);

  }
}
