package com.mandate.Mandate;

import com.mandate.Policeman.Policeman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Kontroler odpowiedzialny za zarządzanie mandatami.
 * Umożliwia policjantom tworzenie nowych mandatów, aktywowanie, anulowanie oraz usuwanie istniejących mandatów.
 * Endpointy dostępne w tym kontrolerze:
 * <ul>
 *     <li><b>GET /api/mandaty</b> - Zwraca listę wszystkich mandatów.</li>
 *     <li><b>POST /api/mandaty</b> - Tworzy nowy mandat.</li>
 *     <li><b>PUT /api/mandaty/{mandateId}/activate</b> - Aktywuje mandat o podanym id.</li>
 *     <li><b>PUT /api/mandaty/{mandateId}/cancel</b> - Anuluje mandat o podanym id.</li>
 *     <li><b>DELETE /api/mandaty/{mandateId}</b> - Usuwa mandat o podanym id.</li>
 * </ul>
 */
@Controller
@RequestMapping(path = {"/api/mandaty"})
public class MandateController {

    private final MandateService mandateService;

    /**
     * Konstruktor, który wstrzykuje zależność serwisu MandateService.
     *
     * @param mandateService Klasa zawierająca metody do operacji z mandatami
     */
    @Autowired
    public MandateController(MandateService mandateService) {
        this.mandateService = mandateService;
    }

    /**
     * Endpoint GET, który zwraca listę wszystkich mandatów.
     *
     * @return Listę wszystkich mandatów.
     */
    @GetMapping
    public List<Mandate> getMandates() {
        return mandateService.getMandates();
    }

    /**
     * Endpoint POST, który tworzy nowy mandat na podstawie przesłanych danych.
     *
     * @param mandate Obiekt Mandate, który ma zostać zapisany w bazie danych.
     * @return Utworzony mandat.
     */
    @PostMapping
    public Mandate createMandate(@RequestBody Mandate mandate) {
        return mandateService.createMandate(mandate);
    }

    /**
     * Endpoint PUT, który aktywuje mandat o podanym identyfikatorze.
     *
     * @param mandateId Identyfikator mandatu, który ma zostać aktywowany.
     * @return Zaktualizowany mandat o statusie aktywnym.
     * @throws IllegalStateException Jeśli mandat nie istnieje lub jest już aktywny.
     */
    @PutMapping("/{mandateId}/activate")
    public Mandate activateMandate(@PathVariable Long mandateId) {
        return mandateService.activateMandate(mandateId);
    }

    /**
     * Endpoint PUT, który anuluje mandat o podanym identyfikatorze.
     *
     * @param mandateId Identyfikator mandatu, który ma zostać anulowany.
     * @return Zaktualizowany mandat o statusie anulowanym.
     * @throws IllegalStateException Jeśli mandat nie istnieje lub jest już anulowany.
     */
    @PutMapping("/{mandateId}/cancel")
    public Mandate cancelMandate(@PathVariable Long mandateId) {
        return mandateService.cancelMandate(mandateId);
    }

    /**
     * Endpoint DELETE, który usuwa mandat o podanym id.
     *
     * @param mandateId Id mandatu, który ma zostać usunięty.
     * @throws IllegalStateException Jeśli mandat o podanym identyfikatorze nie istnieje.
     */
    @DeleteMapping(path = {"{mandateId}"})
    public void deleteMandate(@PathVariable("mandateId") Long mandateId) {
        mandateService.deleteMandate(mandateId);
    }
}
