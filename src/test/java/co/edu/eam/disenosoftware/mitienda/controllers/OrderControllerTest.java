package co.edu.eam.disenosoftware.mitienda.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.model.entities.OrderProduct;
import co.edu.eam.disenosoftware.mitienda.model.responses.ErrorResponse;
import co.edu.eam.disenosoftware.mitienda.repositories.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.http.HttpStatus;
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
public class OrderControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @PersistenceContext
  private EntityManager em;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private OrdersController ordersController;

  @Autowired
  private OrderRepository orderRepository;

  @Test
  @Sql("/testdata/controllers/getExistingOrderById.sql")
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
    Assertions.assertEquals(HttpStatus.OK.value(), status);
  }

  @Test
  public void getNotExistingOrderByID() throws Exception {
    //Crear la Peticion
    RequestBuilder request = MockMvcRequestBuilders.get("/api/orders/1");

    //Hacer la peticion
    ResultActions result = mockMvc.perform(request);

    //Sacar los resultados de la peticion
    int status = result.andReturn().getResponse().getStatus();

    //hacer las asersiones

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
  @Sql({"/testdata/controllers/finalized_order_without_order_products_controller.sql"})
  public void finalizedOrderWithoutOrderProducts() throws Exception {
    //Crear la Peticion
    RequestBuilder request = MockMvcRequestBuilders.patch("/api/orders/1/end");

    //Hacer la peticion
    ResultActions result = mockMvc.perform(request);

    //Sacar los resultados de la peticion
    int status = result.andReturn().getResponse().getStatus();

    //hacer las asersiones

    Assertions.assertEquals(404, status);
  }

  @Test
  @Sql({"/testdata/controllers/finalized_order_with_not_already_order_controller.sql"})
  public void finalizedOrderWithNotAlreadyOrder () throws Exception {
    //Crear la Peticion
    RequestBuilder request = MockMvcRequestBuilders.patch("/api/orders/1/end");

    //Hacer la peticion
    ResultActions result = mockMvc.perform(request);

    //Sacar los resultados de la peticion
    int status = result.andReturn().getResponse().getStatus();

    //hacer las asersiones

    Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED.value(), status);
  }

  @Test
  @Sql({"/testdata/controllers/finalized_order.sql"})
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

  @Test
  @Sql({"/testdata/deliver_order_api.sql"})
  public void deliverOrderTest() throws Exception{

  //Crear la peticion

    RequestBuilder requestBuilder = MockMvcRequestBuilders.patch("/api/orders/1/delivery");
    //Hacer La Peticion
    ResultActions resultActions=  mockMvc.perform(requestBuilder);
    // Sacar los resultado de la peticion
    int status=resultActions.andReturn().getResponse().getStatus();

    // Hacer las assertions
    Order order=orderRepository.find(1L);

    Assertions.assertEquals(HttpStatus.OK.value(), status);

    Assertions.assertEquals("delivered",order.getState());
  }
  @Test
  @Sql({"/testdata/delive_order_state_not_finished_api.sql"})
  public void deliveOrderStateNotFinishedTest() throws Exception {

    //Crear la peticion

    RequestBuilder requestBuilder = MockMvcRequestBuilders.patch("/api/orders/1/delivery");
    //Hacer La Peticion
    ResultActions resultActions=  mockMvc.perform(requestBuilder);
    // Sacar los resultado de la peticion
    int status=resultActions.andReturn().getResponse().getStatus();

    // Hacer las assertions

    Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED.value(), status);
  }
  @Test
  @Sql({"/testdata/deliver_order_not_found_api.sql"})
  public void deliverOrderNotFoundTest() throws Exception {
    //Crear la peticion
    RequestBuilder requestBuilder = MockMvcRequestBuilders.patch("/api/orders/2/delivery");
    //Hacer La Peticion
    ResultActions resultActions=  mockMvc.perform(requestBuilder);
    // Sacar los resultado de la peticion
    int status=resultActions.andReturn().getResponse().getStatus();
    // Hacer las assertions
    Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), status);
  }

  @Test
  @Sql({"/testdata/controllers/controller_add_product_to_order_test.sql"})
  public void controllerAddProductToOrderTest() throws Exception  {
    String jsonBody = "{\n" +
            "    \"id\": 3,\n" +
            "    \"quantity\": 1\n" +
            "}";
    RequestBuilder request = MockMvcRequestBuilders.put("/api/orders/1/add-product")
            .contentType("application/json")
            .content(jsonBody);

    ResultActions result = mockMvc.perform(request);

    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    Assertions.assertEquals(HttpStatus.OK.value(), status);

    Order order = objectMapper.readValue(body,Order.class);

    Assertions.assertEquals(3L,order.getProduct().get(2).getProductStore().getId());
    Assertions.assertEquals(1,order.getProduct().get(2).getQuantity());
  }

  @Test
  @Sql({"/testdata/controllers/controller_add_product_to_order_when_canceled_test.sql"})
  public void controllerAddProductToOrderWhenCanceledTest() throws Exception  {
    String jsonBody = "{\n" +
            "    \"id\": 3,\n" +
            "    \"quantity\": 1\n" +
            "}";
    RequestBuilder request = MockMvcRequestBuilders.put("/api/orders/1/add-product")
            .contentType("application/json")
            .content(jsonBody);

    ResultActions result = mockMvc.perform(request);

    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED.value(), status);

    ErrorResponse error = objectMapper.readValue(body, ErrorResponse.class);
    Assertions.assertEquals("0025", error.getErrorCode());

  }

  @Test
  @Sql({"/testdata/controllers/controller_add_product_to_order_when_finished_test.sql"})
  public void controllerAddProductToOrderWhenFinishedTest() throws Exception  {
    String jsonBody = "{\n" +
            "    \"id\": 2,\n" +
            "    \"quantity\": 1\n" +
            "}";
    RequestBuilder request = MockMvcRequestBuilders.put("/api/orders/1/add-product")
            .contentType("application/json")
            .content(jsonBody);

    ResultActions result = mockMvc.perform(request);

    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED.value(), status);

    ErrorResponse error = objectMapper.readValue(body, ErrorResponse.class);
    Assertions.assertEquals("0025", error.getErrorCode());
  }

  @Test
  @Sql({"/testdata/controllers/controller_add_product_to_order_when_product_store_not_found_test.sql"})
  public void controllerAddProductToOrderWhenProductStoreNotFoundTest() throws Exception  {
    String jsonBody = "{\n" +
            "    \"id\": 3,\n" +
            "    \"quantity\": 1\n" +
            "}";
    RequestBuilder request = MockMvcRequestBuilders.put("/api/orders/1/add-product")
            .contentType("application/json")
            .content(jsonBody);

    ResultActions result = mockMvc.perform(request);

    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), status);

    ErrorResponse error = objectMapper.readValue(body, ErrorResponse.class);
    Assertions.assertEquals("0026", error.getErrorCode());
  }

  @Test
  @Sql({"/testdata/controllers/controller_add_product_to_order_when_price_limit_is_exceeded_test.sql"})
  public void controllerAddProductToOrderWhenPriceLimitPercentageIsExceededTest() throws Exception  {
    String jsonBody = "{\n" +
            "    \"id\": 3,\n" +
            "    \"quantity\": 2\n" +
            "}";
    RequestBuilder request = MockMvcRequestBuilders.put("/api/orders/1/add-product")
            .contentType("application/json")
            .content(jsonBody);

    ResultActions result = mockMvc.perform(request);

    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED.value(), status);

    ErrorResponse error = objectMapper.readValue(body, ErrorResponse.class);
    Assertions.assertEquals("0027", error.getErrorCode());
  }

  @Test
  public void controllerShoppingCartNullTest() throws Exception {
    RequestBuilder request = MockMvcRequestBuilders.post("/api/orders/from-shoppingcart/1");

    ResultActions result = mockMvc.perform(request);

    int status = result.andReturn().getResponse().getStatus();

    Assertions.assertEquals(404, status);
  }

  @Test
  @Sql({"/testdata/controllers/controller_not_found_products.sql"})
  public void controllerNotFoundProductsTest() throws Exception {
    RequestBuilder request = MockMvcRequestBuilders.post("/api/orders/from-shoppingcart/1");

    ResultActions result = mockMvc.perform(request);

    int status = result.andReturn().getResponse().getStatus();

    Assertions.assertEquals(412, status);
  }

  @Test
  @Sql({"/testdata/controllers/controller_user_orders_exceed_five.sql"})
  public void controllerUserOrdersExceedFiveTest() throws Exception {
    RequestBuilder request = MockMvcRequestBuilders.post("/api/orders/from-shoppingcart/1");

    ResultActions result = mockMvc.perform(request);
    
    int status = result.andReturn().getResponse().getStatus();

    Assertions.assertEquals(412, status);
  }

  @Test
  @Sql({"/testdata/controllers/controller_create_order_test.sql"})
  public void controllerCreateOrderTest() throws Exception {
    RequestBuilder request = MockMvcRequestBuilders.post("/api/orders/from-shoppingcart/1");

    ResultActions result = mockMvc.perform(request);

    String body = result.andReturn().getResponse().getContentAsString();
    int status = result.andReturn().getResponse().getStatus();

    Assertions.assertEquals(200, status);
    Assertions.assertEquals("",body);
  }

}
