package com.mandate.Driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repozytorium do operacji na encji Driver.
 * Dziedziczy po JpaRepository}, co umożliwia dostęp do podstawowych operacji CRUD,
 * takich jak zapisywanie, usuwanie, aktualizowanie i wyszukiwanie danych.
 * Zawiera dodatkową metodę do wyszukiwania kierowcy po numerze PESEL.
 */
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    /**
     * Metoda do wyszukiwania kierowcy na podstawie numeru PESEL.
     *
     * @param pesel numer PESEL kierowcy, którego dane mają zostać pobrane.
     * @return obiekt typu Optional<Driver> zawierający kierowcę, jeśli taki istnieje.
     */
    @Query("select d from Driver d where d.pesel = ?1")
    Optional<Driver> findDriverByPesel(String pesel);
}
