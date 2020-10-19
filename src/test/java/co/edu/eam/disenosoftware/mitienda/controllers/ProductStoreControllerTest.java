package co.edu.eam.disenosoftware.mitienda.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.Request;
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

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ProductStoreControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private EntityManager em;
 @Test
 @Sql("/testdata/controlles_get_all_product_store_by_store_id.sql")
 public void getAllProductStoreByStoreIdTest() throws Exception{

   RequestBuilder request = MockMvcRequestBuilders.get("/api/products-store/stores/2/products");

   ResultActions result = mockMvc.perform((request));

   String body = result.andReturn().getResponse().getContentAsString();
   int status = result.andReturn().getResponse().getStatus();

   Assertions.assertEquals(HttpStatus.OK.value(),status);

   System.out.println(body);

 }

  @Test
  @Sql("/testdata/controlles_not_existing_product_store_by_store_id.sql")
  public void notExistingProductStoreByStoreIdTest() throws Exception{

    RequestBuilder request = MockMvcRequestBuilders.get("/api/products-store/stores/2/products");

    ResultActions result = mockMvc.perform((request));

    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    Assertions.assertEquals(HttpStatus.NOT_FOUND.value(),status);

    System.out.println(body);

  }
}
