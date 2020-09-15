package co.edu.eam.disenosoftware.homeautobackend;

import co.edu.eam.disenosoftware.homeautobackend.model.entities.User;
import co.edu.eam.disenosoftware.homeautobackend.model.entities.UserAddress;
import co.edu.eam.disenosoftware.homeautobackend.repositories.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Runner class.
 */
@SpringBootApplication
public class Application {

  /**
   * Main method.
   *
   * @param args args.
   */
  public static void main(String[] args) { SpringApplication.run(Application.class, args);}
}
