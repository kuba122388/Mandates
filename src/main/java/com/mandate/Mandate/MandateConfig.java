package com.mandate.Mandate;

import com.mandate.Driver.DriverService;
import com.mandate.Policeman.PolicemanService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 *  Klasa konfiguracyjna aplikacji, która tworzy i zapisuje przykładowe mandaty w bazie danych.
 */
@Configuration
public class MandateConfig {

    private final DriverService driverService;
    private final PolicemanService policemanService;

    /**
     * Konstruktor klasy
     *
     * @param driverService klasa zawierająca metody do operacji na kierowcach.
     * @param policemanService klasa zawierająca metody do operacji na policjantach.
     */
    public MandateConfig(DriverService driverService, PolicemanService policemanService) {
        this.driverService = driverService;
        this.policemanService = policemanService;
    }

    /**
     * Bean, który uruchamia metodę CommandLineRunner po starcie aplikacji,
     * w celu zapisania przykładowych mandatów do bazy danych.
     *
     * <p>
     * Ta metoda jest wykonywana przy uruchamianiu aplikacji, ponieważ jest oznaczona adnotacją @Bean.
     * Dodaje przykładowe mandaty do bazy danych.
     * Adnotacja @Order określa kolejność wykonania beanów w przypadku, gdy jest ich więcej niż jeden.
     * </p>
     *
     * @param mandateRepository Repozytorium, do którego zapisane są mandaty
     * @return zwraca obiekt typu CommandLineRunner, który zapisuje przykładowe mandaty do bazy danych.
     */
    @Bean
    @Order(3)
    CommandLineRunner initMandates(MandateRepository mandateRepository) {
        return args -> {
            Mandate mandate1 = new Mandate(
                    null, // ID będzie wygenerowane automatycznie
                    policemanService.getPolicemanByBadge(2463L),
                    driverService.getDriverByPesel("02243005914"),
                    "Przekroczenie prędkości o 30 km/h w terenie zabudowanym",
                    Date.valueOf(LocalDate.of(2002, 4, 30)),
                    "Zduńska Wola",
                    10,
                    false,
                    800f,
                    Status.AKTYWNY
            );

            Mandate mandate2 = new Mandate(
                    null, // ID
                    policemanService.getPolicemanByBadge(2463L),
                    driverService.getDriverByPesel("02243005914"),
                    "Grzebanie w smieciach", // Opis
                    Date.valueOf(LocalDate.of(2024, 6, 22)),
                    "Zduńska Wola",
                    10,
                    false,
                    800f,
                    Status.AKTYWNY
            );

            mandateRepository.saveAll(List.of(mandate1, mandate2));
        };
    }
}
