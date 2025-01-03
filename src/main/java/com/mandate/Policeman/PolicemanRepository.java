package com.mandate.Policeman;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repozytorium do operacji na encji Policeman.
 * Dziedziczy po JpaRepository, co zapewnia dostęp do podstawowych operacji CRUD,
 * takich jak zapisywanie, usuwanie, aktualizowanie i wyszukiwanie mandatów.
 * Repozytorium zawiera metodę umożliwiającą wyszukiwanie policjantów na podstawie ich numeru służbowego.
 */
@Repository
public interface PolicemanRepository extends JpaRepository<Policeman, Long> {

    /**
     * Znajduje policjanta na podstawie jego numeru służbowego.
     *
     * @param numerSluzbowy Numer służbowy policjanta, którego dane mają zostać znalezione.
     * @return Obiekt Optional zawierający policjanta, jeśli istnieje w bazie danych.
     */
    @Query("select d from Policeman d where d.numerSluzbowy = ?1")
    Optional<Policeman> findPolicemanByBadge(Long numerSluzbowy);
}
