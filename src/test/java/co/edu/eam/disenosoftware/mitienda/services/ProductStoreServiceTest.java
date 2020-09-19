package co.edu.eam.disenosoftware.mitienda.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
public class ProductStoreServiceTest {

  @Autowired
  private ProductStoreService service;
  
}
