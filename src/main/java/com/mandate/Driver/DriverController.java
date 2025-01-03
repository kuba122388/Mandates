package com.mandate.Driver;

import com.mandate.Mandate.Mandate;
import com.mandate.Mandate.MandateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Kontroler odpowiedzialny za obsługę zapytań związanych z kierowcami oraz ich mandatami.
 */
@Controller
@RequestMapping(path = "/")
public class DriverController {

    private final DriverService driverService;
    private final MandateService mandateService;

    /**
     * Konstruktor kontrolera.
     *
     * @param driverService  klasa zawierająca metody do operacji na kierowcach.
     * @param mandateService klasa zawierająca metody do operacji na mandatach.
     */
    @Autowired
    public DriverController(DriverService driverService, MandateService mandateService) {
        this.driverService = driverService;
        this.mandateService = mandateService;
    }

    /**
     * Obsługuje zapytanie GET na ścieżkę główną aplikacji.
     * Wyświetla stronę głowną dla kierowcy do wyświetlenia
     * list mandatów po podaniu numeru PESEL.
     *
     * @return zwraca nazwę widoku, która odnosi się do nazwy głównej strony.
     */
    @GetMapping
    public String index() {
        System.out.println("Strona");
        return "index";
    }

    /**
     * Obsługuje zapytanie GET na ścieżkę "/list", zwracając listę wszystkich kierowców.
     *
     * @return zwraca metodę z klasy driverService która zwraca wszystkich kierowców.
     */
    @GetMapping("/list")
    public List<Driver> getDrivers() {
        return driverService.getDrivers();
    }

    /**
     * Obsługuje zapytanie GET na ścieżkę "/driver", pobierając szczegóły dotyczące kierowcy
     * na podstawie numeru PESEL.
     *
     * @param pesel numer PESEL kierowcy, którego dane mają zostać pobrane.
     * @param model obiekt, który umożliwia przekazywanie danych do widoku.
     * @return nazwę widoku, która odnosi się do nazwy głównej strony.
     */
    @GetMapping("/driver")
    public String getDriverByPesel(@RequestParam(value = "pesel", required = false) String pesel, Model model) {
        System.out.println("Pobrano Drivera: " + pesel);
        Driver driver = driverService.getDriverByPesel(pesel);
        List<Mandate> mandates = mandateService.getDriverMandates(driver);
        model.addAttribute("pesel", pesel);
        model.addAttribute("driver", driver);
        model.addAttribute("mandates", mandates);
        return "index";
    }
}
