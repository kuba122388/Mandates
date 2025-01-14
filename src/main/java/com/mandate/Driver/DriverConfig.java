package com.mandate.Driver;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * Klasa konfiguracyjna aplikacji, która tworzy i zapisuje przykładowych kierowców w bazie danych.
 * Używana jest do wstępnego wypełnienia bazy danych przykładowymi danymi o kierowcach
 * podczas uruchamiania aplikacji.
 *
 * <p>Ta klasa korzysta z interfejsu CommandLineRunner w celu zapisania przykładowych kierowców
 * w bazie danych przy starcie aplikacji. Zawiera ona jeden bean, który wykonuje inicjalizację danych.
 * </p>
 */
@Configuration
public class DriverConfig {

    /**
     * Bean, który uruchamia metodę CommandLineRunner po starcie aplikacji,
     * w celu zapisania przykładowych kierowców do bazy danych.
     *
     * <p>
     * Ta metoda jest wykonywana przy uruchamianiu aplikacji, ponieważ jest oznaczona adnotacją @Bean.
     * Dodaje dwóch przykładowych kierowców do bazy danych.
     * Adnotacja @Order określa kolejność wykonania beanów w przypadku, gdy jest ich więcej niż jeden.
     * </p>
     *
     * @param driverRepository Repozytorium, do którego zapisani są kierowcy
     * @return Implementacja CommandLineRunner, która zapisuje przykładowe dane o kierowcach do bazy danych.
     */
    @Bean
    @Order(1)
    CommandLineRunner initDrivers(DriverRepository driverRepository) {
        return args -> {
            Driver d1 = new Driver(
                    "Jakub",
                    "Bak",
                    "02243005914"
            );
            Driver d2 = new Driver(
                    "Albert",
                    "Brożyna",
                    "02894010240"
            );
            Driver d3 = new Driver(
                    "Anna",
                    "Nowak",
                    "02134002345"
            );
            Driver d4 = new Driver(
                    "Piotr",
                    "Kowalski",
                    "03251011234"
            );
            Driver d5 = new Driver(
                    "Maria",
                    "Wiśniewska",
                    "01122019876"
            );
            Driver d6 = new Driver(
                    "Tomasz",
                    "Wójcik",
                    "04327076541"
            );
            Driver d7 = new Driver(
                    "Ewa",
                    "Kamińska",
                    "02567008943"
            );
            Driver d8 = new Driver(
                    "Paweł",
                    "Zieliński",
                    "01432004567"
            );
            Driver d9 = new Driver(
                    "Agnieszka",
                    "Szymańska",
                    "03543011209"
            );
            Driver d10 = new Driver(
                    "Michał",
                    "Lewandowski",
                    "02951023456"
            );

            driverRepository.saveAll(List.of(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10));
        };
    }

}
