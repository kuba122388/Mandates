package com.mandate.Policeman;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * Klasa konfiguracyjna aplikacji, która tworzy i zapisuje przykładowych policjantów w bazie danych.
 * Używana jest do wstępnego wypełnienia bazy danych przykładowymi danymi o policjantach
 * podczas uruchamiania aplikacji.
 *
 * <p>Adnotacja @Configuration oznacza, że klasa jest źródłem definicji beanów dla kontekstu aplikacji Spring.
 * Metoda initPolicemen tworzy i zapisuje obiekty Policeman w repozytorium PolicemanRepository.
 */
@Configuration
public class PolicemanConfig {

    /**
     * Tworzy bean odpowiedzialny za inicjalizację przykładowych danych o policjantach w bazie danych.
     * Adnotacja @Order określa kolejność wykonania beanów w przypadku, gdy jest ich więcej niż jeden.
     * W tym przypadku kolejność jest ustawiona na 2.
     *
     * @param policemanRepository Repozytorium służące do zarządzania danymi o policjantach.
     * @return Implementacja CommandLineRunner, która zapisuje przykładowe dane o policjantach do bazy danych.
     */
    @Bean
    @Order(2)
    CommandLineRunner initPolicemen(PolicemanRepository policemanRepository) {
        return args -> {
            Policeman baku = new Policeman(
                    2463L,
                    "Jan",
                    "Kowalski",
                    "09281028389"
            );
            Policeman boryna = new Policeman(
                    5129L,
                    "Marcin",
                    "Różycki",
                    "2412312240"
            );
            policemanRepository.saveAll(List.of(baku, boryna));
        };
    }
}
