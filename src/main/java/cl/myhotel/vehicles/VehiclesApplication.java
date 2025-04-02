package cl.myhotel.vehicles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the Vehicles application.
 * This class serves as the entry point for the Spring Boot application.
 *
 * @author Leonel Zeballos
 */
@SpringBootApplication
public class VehiclesApplication {

	/**
	 * Main method to run the Vehicles application.
	 *
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(VehiclesApplication.class, args);
	}

}
