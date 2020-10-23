package co.edu.eam.disenosoftware.mitienda.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
public class CategoryControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @PersistenceContext
  private EntityManager em;

  @Test
  @Sql("/testdata/controlles_get_all_category_store_by_store_id.sql")
  public void getAllCategoryByStoreId() throws Exception{

    RequestBuilder request = MockMvcRequestBuilders.get("/api/categories/stores/3/categories");

    ResultActions result = mockMvc.perform((request));

    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    Category category = objectMapper.readValue(body, Category.class);
    Assertions.assertEquals("pedro", category.getName());
  }
}
