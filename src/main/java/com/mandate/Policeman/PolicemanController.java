package com.mandate.Policeman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Kontroler odpowiedzialny za operacje związane z zarządzaniem danymi o policjantach.
 * Udostępnia endpointy do pobierania, dodawania oraz usuwania danych o policjantach.
 *
 * <p>Endpointy dostępne w tym kontrolerze:
 * <ul>
 *     <li><b>GET /api/policjanci</b> - Zwraca listę wszystkich policjantów.</li>
 *     <li><b>GET /api/policjanci/{badge}</b> - Zwraca dane policjanta na podstawie numeru służbowego.</li>
 *     <li><b>POST /api/policjanci</b> - Dodaje nowego policjanta.</li>
 *     <li><b>DELETE /api/policjanci/{PolicemanId}</b> - Usuwa policjanta na podstawie jego numeru służbowego.</li>
 * </ul>
 */
@Controller
@RequestMapping(path = "api/policjanci")
public class PolicemanController {

    private final PolicemanService policemanService;

    /**
     * Konstruktor wstrzykujący zależność do serwisu PolicemanService.
     *
     * @param policemanService Klasa zawierająca metody do operacji związanych z policjantami.
     */
    @Autowired
    public PolicemanController(PolicemanService policemanService) {
        this.policemanService = policemanService;
    }

    /**
     * Endpoint GET, który zwraca listę wszystkich policjantów.
     *
     * @return Lista wszystkich policjantów.
     */
    @GetMapping
    public List<Policeman> getPolicemen() {
        return policemanService.getPolicemen();
    }

    /**
     * Endpoint GET, który zwraca dane policjanta na podstawie numeru służbowego.
     *
     * @param badgeNumber Numer służbowy policjanta.
     * @return Obiekt Policeman odpowiadający podanemu numerowi służbowemu.
     */
    @GetMapping("/{badge}")
    public Policeman getPolicemanByBadge(@RequestParam Long badgeNumber) {
        return policemanService.getPolicemanByBadge(badgeNumber);
    }

    /**
     * Endpoint POST, który dodaje nowego policjanta do systemu.
     *
     * @param policeman Obiekt Policeman reprezentujący nowego policjanta.
     */
    @PostMapping
    public void addNewPoliceman(@RequestBody Policeman policeman) {
        policemanService.addNewPoliceman(policeman);
    }

    /**
     * Endpoint DELETE, który usuwa policjanta z bazy danydch na podstawie jego numeru służbowego.
     *
     * @param PolicemanId Numer służbowy policjanta, który ma zostać usunięty.
     */
    @DeleteMapping(path = {"/{PolicemanId}"})
    public void deletePoliceman(@PathVariable("PolicemanId") Long PolicemanId) {
        policemanService.deletePoliceman(PolicemanId);
    }
}
