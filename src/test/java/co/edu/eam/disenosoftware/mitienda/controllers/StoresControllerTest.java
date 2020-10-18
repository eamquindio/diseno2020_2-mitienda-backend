package co.edu.eam.disenosoftware.mitienda.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.repositories.StoreRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

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
}
