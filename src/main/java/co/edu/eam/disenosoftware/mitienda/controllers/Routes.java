package co.edu.eam.disenosoftware.mitienda.controllers;

/**
 * Class to define all rest api paths
 */
public class Routes {

  /**
   * base uri
   */
  public static final String BASE_PATH = "/api";

  /**
   * stores base uri
   */
  public static final String STORES_PATH = BASE_PATH + "/stores";

  /**
   * get all stores
   */
  public static final String GET_ALL_STORES = "";

  public static final String ORDERS_PATH = BASE_PATH + "/orders";

  public static final String GET_ORDER = "/{orderId}";

}
