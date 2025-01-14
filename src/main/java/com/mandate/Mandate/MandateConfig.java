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
            Mandate m1 = new Mandate(
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

            Mandate m2 = new Mandate(
                    null, // ID
                    policemanService.getPolicemanByBadge(2463L),
                    driverService.getDriverByPesel("02243005914"),
                    "Grzebanie w śmieciach", // Opis
                    Date.valueOf(LocalDate.of(2024, 6, 22)),
                    "Zduńska Wola",
                    10,
                    false,
                    800f,
                    Status.AKTYWNY
            );

            Mandate m3 = new Mandate(
                    null,
                    policemanService.getPolicemanByBadge(5129L),
                    driverService.getDriverByPesel("02894010240"),
                    "Nieustąpienie pierwszeństwa na skrzyżowaniu",
                    Date.valueOf(LocalDate.of(2023, 3, 15)),
                    "Łódź",
                    8,
                    true,
                    500f,
                    Status.AKTYWNY
            );

            Mandate m4 = new Mandate(
                    null,
                    policemanService.getPolicemanByBadge(5129L),
                    driverService.getDriverByPesel("02134002345"),
                    "Brak zapiętych pasów bezpieczeństwa",
                    Date.valueOf(LocalDate.of(2023, 12, 5)),
                    "Łask",
                    5,
                    false,
                    200f,
                    Status.AKTYWNY
            );

            Mandate m5 = new Mandate(
                    null,
                    policemanService.getPolicemanByBadge(2463L),
                    driverService.getDriverByPesel("03251011234"),
                    "Parkowanie na miejscu dla niepełnosprawnych bez uprawnień",
                    Date.valueOf(LocalDate.of(2023, 7, 18)),
                    "Pabianice",
                    6,
                    false,
                    300f,
                    Status.AKTYWNY
            );

            Mandate m6 = new Mandate(
                    null,
                    policemanService.getPolicemanByBadge(5129L),
                    driverService.getDriverByPesel("02567008943"),
                    "Jazda pod wpływem alkoholu",
                    Date.valueOf(LocalDate.of(2022, 11, 10)),
                    "Sieradz",
                    15,
                    true,
                    2000f,
                    Status.ANULOWANY
            );

            Mandate m7 = new Mandate(
                    null,
                    policemanService.getPolicemanByBadge(7312L),
                    driverService.getDriverByPesel("03543011209"),
                    "Przekroczenie prędkości o 50 km/h w terenie zabudowanym",
                    Date.valueOf(LocalDate.of(2023, 1, 22)),
                    "Zduńska Wola",
                    12,
                    false,
                    1200f,
                    Status.ANULOWANY
            );

            Mandate m8 = new Mandate(
                    null,
                    policemanService.getPolicemanByBadge(4821L),
                    driverService.getDriverByPesel("02951023456"),
                    "Nieprawidłowe wyprzedzanie",
                    Date.valueOf(LocalDate.of(2023, 8, 14)),
                    "Bełchatów",
                    10,
                    false,
                    1000f,
                    Status.AKTYWNY
            );

            Mandate m9 = new Mandate(
                    null,
                    policemanService.getPolicemanByBadge(5623L),
                    driverService.getDriverByPesel("01122019876"),
                    "Korzystanie z telefonu podczas jazdy",
                    Date.valueOf(LocalDate.of(2024, 1, 2)),
                    "Zgierz",
                    5,
                    true,
                    300f,
                    Status.ANULOWANY
            );

            Mandate m10 = new Mandate(
                    null,
                    policemanService.getPolicemanByBadge(7312L),
                    driverService.getDriverByPesel("04327076541"),
                    "Jazda bez uprawnień",
                    Date.valueOf(LocalDate.of(2023, 5, 10)),
                    "Łódź",
                    20,
                    false,
                    2500f,
                    Status.AKTYWNY
            );

            mandateRepository.saveAll(List.of(m1, m2, m3, m4, m5, m6, m7, m8, m9, m10));
        };

    }
}
