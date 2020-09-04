package co.edu.eam.disenosoftware.homeautobackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Runner class.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

  /**
   * Main method.
   *
   * @param args args.
   */
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }


  @Override
  public void run(String... args) throws Exception {

  }
}
