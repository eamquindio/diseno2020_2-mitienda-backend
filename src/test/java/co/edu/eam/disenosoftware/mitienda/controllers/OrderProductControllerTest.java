package co.edu.eam.disenosoftware.mitienda.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.OrderProduct;
import co.edu.eam.disenosoftware.mitienda.model.responses.ErrorResponse;
import co.edu.eam.disenosoftware.mitienda.repositories.OrderProductRepository;
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
public class OrderProductControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private OrderProductRepository orderProductRepository;

  @Test
  @Sql("/testdata/controllers/check_order_product_exist_and_pending.sql")
  public void checkOrderProductExistAndPendingTest () throws Exception {
    RequestBuilder request = MockMvcRequestBuilders.put("/api/order-products/1/check-product");

    ResultActions result = mockMvc.perform(request);

    int numberStatus = result.andReturn().getResponse().getStatus();

    OrderProduct orderProduct = orderProductRepository.find(1L);

    Assertions.assertEquals("checked",orderProduct.getState());
    Assertions.assertEquals(HttpStatus.OK.value(),numberStatus);
  }

  @Test
  @Sql("/testdata/controllers/check_order_product_exist_not_pending.sql")
  public void checkOrderProductExistNotPendingTest () throws Exception {
    RequestBuilder request = MockMvcRequestBuilders.put("/api/order-products/1/check-product");

    ResultActions result = mockMvc.perform(request);

    int numberStatus = result.andReturn().getResponse().getStatus();

    Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED.value(),numberStatus);
  }

  @Test
  @Sql("/testdata/controllers/check_not_exist_order_product.sql")
  public void checkOrderProductNotExistTest () throws Exception {
    RequestBuilder request = MockMvcRequestBuilders.put("/api/order-products/1/check-product");

    ResultActions result = mockMvc.perform(request);

    int numberStatus = result.andReturn().getResponse().getStatus();

    OrderProduct orderProduct = orderProductRepository.find(1L);

    Assertions.assertNull(orderProduct);
    Assertions.assertEquals(HttpStatus.NOT_FOUND.value(),numberStatus);
  }

  @Test
  @Sql({"/testdata/controllers/delete_product_request.sql"})
  public void deleteProductRequest() throws Exception {
    RequestBuilder request = MockMvcRequestBuilders.delete("/api/order-products/1");

    ResultActions result = mockMvc.perform(request);

    int status = result.andReturn().getResponse().getStatus();

    Assertions.assertEquals(HttpStatus.OK.value(), status);
  }

  @Test
  @Sql({"/testdata/controllers/not_exist_product_request.sql"})
  public void NotExistProductRequest() throws Exception {
    RequestBuilder request = MockMvcRequestBuilders.delete("/api/order-products/44");

    ResultActions result = mockMvc.perform(request);

    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    ErrorResponse error = objectMapper.readValue(body, ErrorResponse.class);
    Assertions.assertEquals("0028", error.getErrorCode());
  }

}
