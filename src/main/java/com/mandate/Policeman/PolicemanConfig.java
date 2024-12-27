package com.mandate.Policeman;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class PolicemanConfig {
    @Bean
    CommandLineRunner initPolicemen(PolicemanRepository policemanRepository){
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
