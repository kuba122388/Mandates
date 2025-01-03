package com.mandate;

import com.mandate.Driver.Driver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Główna klasa aplikacji MandateProject.
 * <p>Odpowiada za uruchomienie aplikacji Spring Boot.

 */
@SpringBootApplication
public class MandateProjectApplication {

	/**
	 * Główna metoda uruchamiająca aplikację.
	 *
	 * @param args Argumenty przekazywane do aplikacji z linii poleceń.
	 */
	public static void main(String[] args) {
		SpringApplication.run(MandateProjectApplication.class, args);
	}
}
