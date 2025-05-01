package pe.edu.vallegrande.workshop;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkshopApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load(); // Carga el archivo .env automáticamente
		dotenv.entries().forEach(entry ->
				System.setProperty(entry.getKey(), entry.getValue())
		);
		SpringApplication.run(WorkshopApplication.class, args);
	}
}
