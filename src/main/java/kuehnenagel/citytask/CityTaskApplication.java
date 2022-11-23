package kuehnenagel.citytask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CityTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityTaskApplication.class, args);
	}

}
