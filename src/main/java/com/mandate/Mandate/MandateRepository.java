package com.mandate.Mandate;

import com.mandate.Driver.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repozytorium do operacji na encji Mandate.
 * Dziedziczy po JpaRepository, co zapewnia dostęp do podstawowych operacji CRUD,
 * takich jak zapisywanie, usuwanie, aktualizowanie i wyszukiwanie mandatów.
 * Repozytorium zawiera również metody umożliwiające wyszukiwanie mandatów na podstawie ich identyfikatora
 * oraz na podstawie przypisanego kierowcy.
 */
@Repository
public interface MandateRepository extends JpaRepository<Mandate, Long> {

    /**
     * Metoda do wyszukiwania mandatu na podstawie jego id.
     *
     * @param Id identyfikator mandatu, który ma zostać wyszukany.
     * @return Optional<Mandate> zwraca mandat, jeśli taki istnieje.
     */
    @Query("select m from Mandate m where m.id = ?1")
    Optional<Mandate> findMandateById(String Id);

    /**
     * Metoda do wyszukiwania mandatów przypisanych do konkretnego kierowcy.
     *
     * @param driver kierowca, którego mandaty mają zostać pobrane.
     * @return Optional<List < Mandate>> lista mandatów kierowcy, jeśli kierowca posiada mandaty.
     */
    @Query("select m from Mandate m where m.kierowca = ?1")
    Optional<List<Mandate>> findMandateByDriver(Driver driver);
}
