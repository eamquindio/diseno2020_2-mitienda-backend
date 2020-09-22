package co.edu.eam.disenosoftware.mitienda.model.request;

public class CreateOrderRequest {

  private Double totalValue;

  private Long storeId;

  public Double getTotalValue() {
    return totalValue;
  }

  public void setTotalValue(Double totalValue) {
    this.totalValue = totalValue;
  }

  public Long getStoreId() {
    return storeId;
  }

  public void setStoreId(Long storeId) {
    this.storeId = storeId;
  }
}
