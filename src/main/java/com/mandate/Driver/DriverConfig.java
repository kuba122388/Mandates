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
            Driver baku = new Driver(
                    "Jakub",
                    "Bak",
                    "02243005914"
            );
            Driver boryna = new Driver(
                    "Albert",
                    "Brożyna",
                    "02894010240"
            );
            driverRepository.saveAll(List.of(baku, boryna));
        };
    }
}
