package com.mandate.Policeman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Klasa odpowiedzialna za zarządzanie operacjami związanymi z policjantami.
 * Zapewnia metody do zarządzania danymi policjantów, takie jak pobieranie wszystkich policjantów,
 * wyszukiwanie ich numerze służbowym, dodawanie nowych oraz usuwanie istniejących policjantów.</p>
 */
@Service
public class PolicemanService {

    private final PolicemanRepository policemanRepository;

    /**
     * Konstruktor wstrzykujący repozytorium PolicemanRepository.
     *
     * @param policemanRepository Repozytorium do operacji na danych policjantów.
     */
    @Autowired
    public PolicemanService(PolicemanRepository policemanRepository) {
        this.policemanRepository = policemanRepository;
    }

    /**
     * Pobiera listę wszystkich policjantów.
     *
     * @return Lista wszystkich policjantów.
     */
    public List<Policeman> getPolicemen() {
        return policemanRepository.findAll();
    }

    /**
     * Wyszukuje policjanta na podstawie numeru służbowego.
     *
     * @param numerSluzbowy Numer służbowy policjanta, którego dane mają zostać znalezione.
     * @return Obiekt Policeman odpowiadający podanemu numerowi służbowemu.
     * @throws IllegalStateException Jeśli policjant o podanym numerze służbowym nie istnieje.
     */
    public Policeman getPolicemanByBadge(Long numerSluzbowy) {
        Optional<Policeman> policeman = policemanRepository.findPolicemanByBadge(numerSluzbowy);
        if (policeman.isEmpty()) {
            throw new IllegalStateException("Policeman with Badge Number of: " + numerSluzbowy + " does not exist");
        }
        return policeman.get();
    }

    /**
     * Dodaje nowego policjanta do bazy danych.
     *
     * @param policeman Obiekt Policeman, który ma zostać zapisany.
     * @throws IllegalStateException Jeśli numer służbowy policjanta już istnieje.
     */
    public void addNewPoliceman(Policeman policeman) {
        Optional<Policeman> policemanOptional = policemanRepository.findPolicemanByBadge(policeman.getNumerSluzbowy());
        if (policemanOptional.isPresent()) {
            Policeman existingPoliceman = policemanOptional.get();
            throw new IllegalStateException("Badge number already exists and belongs to: " + existingPoliceman);
        }
        this.policemanRepository.save(policeman);
    }

    /**
     * Usuwa policjanta na podstawie numeru służbowego.
     *
     * @param badgeId Numer służbowy policjanta, który ma zostać usunięty.
     * @throws IllegalStateException Jeśli policjant o podanym numerze służbowym nie istnieje.
     */
    public void deletePoliceman(Long badgeId) {
        boolean exists = policemanRepository.existsById(badgeId);
        if (!exists) {
            throw new IllegalStateException("Policeman with badge number: " + badgeId + " does not exist");
        }
        policemanRepository.deleteById(badgeId);
    }
}
