package com.mandate.Driver;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class DriverConfig {
    @Bean
    @Order(1)
    CommandLineRunner initDrivers(DriverRepository driverRepository){
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
