package com.mandate.Mandate;

import com.mandate.Driver.Driver;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Klasa odpowiedzialna za zarządzanie operacjami związanymi z mandatami.
 * Zawiera metody do pobierania, tworzenia, aktywowania, anulowania oraz usuwania mandatów.
 */
@Service
public class MandateService {

    private final MandateRepository mandateRepository;

    /**
     * Konstruktor wstrzykujący zależność do repozytorium mandatów.
     *
     * @param mandateRepository Repozytorium używane do operacji na mandatach.
     */
    @Autowired
    public MandateService(MandateRepository mandateRepository) {
        this.mandateRepository = mandateRepository;
    }

    /**
     * Metoda zwracająca listę wszystkich mandatów.
     *
     * @return Lista wszystkich mandatów znajdujących się w bazie danych.
     */
    public List<Mandate> getMandates() {
        return mandateRepository.findAll();
    }

    /**
     * Metoda zwracająca listę mandatów przypisanych do określonego kierowcy.
     *
     * @param driver Kierowca, którego mandaty mają zostać pobrane.
     * @return Lista mandatów przypisanych do tego kierowcy.
     */
    public List<Mandate> getDriverMandates(Driver driver) {
        Optional<List<Mandate>> mandates = mandateRepository.findMandateByDriver(driver);
        return mandates.orElse(null);
    }

    /**
     * Metoda służąca do tworzenia nowego mandatu.
     *
     * @param mandate mandat, który ma zostać zapisany w bazie danych.
     * @return Utworzony mandat.
     * @throws IllegalStateException jeśli mandat jest nullem.
     */
    public Mandate createMandate(Mandate mandate) {
        if (mandate == null)
            throw new IllegalStateException("Cannot create null mandate");
        mandateRepository.save(mandate);
        return mandate;
    }

    /**
     * Metoda do aktywowania mandatu o podanym id.
     * Sprawdza czy mandat istnieje, i czy nie jest juz aktywny,
     * jeśli istnieje i nie jest aktywny to ustawia jego status na aktywny.
     *
     * @param mandateId Id mandatu, który ma zostać aktywowany.
     * @return Zaktualizowany mandat o statusie aktywnym.
     * @throws IllegalStateException Jeśli mandat nie istnieje lub jest już aktywny.
     */
    @Transactional
    public Mandate activateMandate(Long mandateId) {
        Mandate existingMandate = mandateRepository.findById(mandateId).orElseThrow(() ->
                new IllegalStateException("Mandate does not exist"));

        if (existingMandate.getStatus() == Status.AKTYWNY)
            throw new IllegalStateException("Mandate is already active");
        existingMandate.setStatus(Status.AKTYWNY);
        return existingMandate;
    }

    /**
     * Metoda do anulowania mandatu o podanym id.
     * Sprawdza czy mandat istnieje, i czy nie jest juz anulowany,
     * jeśli istnieje i nie jest anulowany to ustawia jego status na anulowany.
     *
     * @param mandateId Id mandatu, który ma zostać anulowany.
     * @return Zaktualizowany mandat o statusie anulowanym.
     * @throws IllegalStateException Jeśli mandat nie istnieje lub jest już anulowany.
     */
    @Transactional
    public Mandate cancelMandate(Long mandateId) {
        Mandate existingMandate = mandateRepository.findById(mandateId).orElseThrow(() ->
                new IllegalStateException("Mandate does not exist"));

        if (existingMandate.getStatus() == Status.ANULOWANY)
            throw new IllegalStateException("Mandate is already canceled");
        existingMandate.setStatus(Status.ANULOWANY);
        return existingMandate;
    }

    /**
     * Metoda do usuwania mandatu o podanym id.
     * Sprawdza, czy mandat istnieje w bazie, a następnie usuwa go.
     *
     * @param mandateId Id mandatu, który ma zostać usunięty.
     * @throws IllegalStateException Jeśli mandat o podanym id nie istnieje w bazie.
     */
    public void deleteMandate(Long mandateId) {
        boolean exists = mandateRepository.existsById(mandateId);
        if (!exists) {
            throw new IllegalStateException("Mandate with mandateId: " + mandateId + " does not exist");
        }
        mandateRepository.deleteById(mandateId);
    }
}
