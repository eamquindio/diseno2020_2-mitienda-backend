package co.edu.eam.disenosoftware.mitienda.controllers;

import co.edu.eam.disenosoftware.mitienda.exceptions.BusinessException;
import co.edu.eam.disenosoftware.mitienda.exceptions.ErrorCodesEnum;
import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.repositories.OrderRepository;
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

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class OrderControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private OrdersController ordersController;

  @Autowired
  private OrderRepository orderRepository;

  @Test
  @Sql("/testdata/getExistingOrderById.sql")
  public void getExistingOrderByID() throws Exception {
    //Crear la Peticion
    RequestBuilder request = MockMvcRequestBuilders.get("/api/orders/1");

    //Hacer la peticion
    ResultActions result = mockMvc.perform(request);

    //Sacar los resultados de la peticion
    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    //hacer las asersiones
    Order order = objectMapper.readValue(body, Order.class);

    Assertions.assertEquals(1l, order.getId());
    Assertions.assertEquals("finished", order.getState());
    Assertions.assertEquals(1l, order.getUser().getId());
    Assertions.assertEquals(1l, order.getStore().getId());
  }

  @Test
  public void getNotExistingOrderByID() throws Exception {
    //Crear la Peticion
    RequestBuilder request = MockMvcRequestBuilders.get("/api/orders/1");

    //Hacer la peticion
    ResultActions result = mockMvc.perform(request);

    //Sacar los resultados de la peticion
    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    //hacer las asersiones
    Order order = objectMapper.readValue(body, Order.class);

    Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), status);
  }

  @Test
  public void finalizeOrderWithNotFoundOrderTest() throws Exception {
    //Crear la Peticion
    RequestBuilder request = MockMvcRequestBuilders.patch("/api/orders/1/end");

    //Hacer la peticion
    ResultActions result = mockMvc.perform(request);

    //Sacar los resultados de la peticion
    int status = result.andReturn().getResponse().getStatus();

    //hacer las asersiones

    Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), status);
  }

  @Test
  @Sql({"/testdata/finalized_order_without_order_products_controller.sql"})
  public void finalizedOrderWithoutOrderProducts() throws Exception {
    //Crear la Peticion
    RequestBuilder request = MockMvcRequestBuilders.patch("/api/orders/1/end");

    //Hacer la peticion
    ResultActions result = mockMvc.perform(request);

    //Sacar los resultados de la peticion
    int status = result.andReturn().getResponse().getStatus();

    //hacer las asersiones

    Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), status);
  }

  @Test
  @Sql({"/testdata/finalized_order_with_not_already_order_controller.sql"})
  public void finalizedOrderWithNotAlreadyOrder () throws Exception {
    //Crear la Peticion
    RequestBuilder request = MockMvcRequestBuilders.patch("/api/orders/1/end");

    //Hacer la peticion
    ResultActions result = mockMvc.perform(request);

    //Sacar los resultados de la peticion
    int status = result.andReturn().getResponse().getStatus();

    //hacer las asersiones

    Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), status);
  }

  @Test
  @Sql({"/testdata/finalized_order.sql"})
  public void finalizedOrder () throws Exception {
    //Crear la Peticion
    RequestBuilder request = MockMvcRequestBuilders.patch("/api/orders/1/end");

    //Hacer la peticion
    ResultActions result = mockMvc.perform(request);

    //Sacar los resultados de la peticion
    int status = result.andReturn().getResponse().getStatus();

    //hacer las asersiones
    Order order = orderRepository.find(1L);

    Assertions.assertEquals("finished", order.getState());
    Assertions.assertEquals(HttpStatus.OK.value(), status);
  }

}
