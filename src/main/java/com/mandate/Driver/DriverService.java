package com.mandate.Driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Klasa odpowiedzialna za operacje związane z kierowcami.
 * Zawiera metody do pobierania kierowców z bazy danych.
 */
@Service
public class DriverService {

    private final DriverRepository driverRepository;

    /**
     * Konstruktor klasy.
     *
     * @param driverRepository repozytorium, które służy do wykonywania operacji na danych kierowców.
     */
    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    /**
     * Pobiera listę wszystkich kierowców z bazy danych.
     *
     * @return lista obiektów Driver, zawierająca wszystkich kierowców w bazie danych.
     */
    public List<Driver> getDrivers() {
        return driverRepository.findAll();
    }

    /**
     * Pobiera kierowcę na podstawie numeru PESEL.
     *
     * @param pesel numer PESEL kierowcy.
     * @return obiekt Driver, który pasuje do podanego numeru PESEL lub null, jeśli kierowca nie istnieje.
     */
    public Driver getDriverByPesel(String pesel) {
        Optional<Driver> driver = driverRepository.findDriverByPesel(pesel);
        return driver.orElse(null);
    }
}
