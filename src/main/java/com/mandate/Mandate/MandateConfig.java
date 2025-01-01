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

@Configuration
public class MandateConfig {
    private final DriverService driverService;
    private final PolicemanService policemanService;

    public MandateConfig(DriverService driverService, PolicemanService policemanService) {
        this.driverService = driverService;
        this.policemanService = policemanService;
    }

    @Bean
    @Order(3)
    CommandLineRunner initMandates(MandateRepository mandateRepository){
        return args -> {
            Mandate mandate1 = new Mandate(
                    null,
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
                    null,
                    policemanService.getPolicemanByBadge(2463L),
                    driverService.getDriverByPesel("02243005914"),
                    "Grzebanie w smieciach",
                    Date.valueOf(LocalDate.of(2024, 6, 22)),
                    "Zduńska Wola",
                    10,
                    false,
                    800f,
                    Status.AKTYWNY
            );

            mandateRepository.saveAll(List.of(mandate1, mandate2)); // Zapisanie mandatu w bazie danych
        };
    }
}
