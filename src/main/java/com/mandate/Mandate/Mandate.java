package com.mandate.Mandate;

import com.mandate.Driver.Driver;
import com.mandate.Policeman.Policeman;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Klasa reprezentująca encję "Mandate" w aplikacji.
 * Mapuje klasę Mandate na tabelę "Mandates" w bazie danych.
 * Reprezentuje mandat wystawiony kierowcy przez policjanta.
 *
 * <p>Struktura tabeli:</p>
 * <ul>
 *     <li>id (klucz główny, generowany automatycznie)</li>
 *     <li>policjant (właściciel mandatu, klucz obcy do tabeli Policjanci)</li>
 *     <li>kierowca (osoba która otrzymała mandat, klucz obcy do tabeli Kierowcy)</li>
 *     <li>wykroczenie (opis wykroczenia które zostało popełnione)</li>
 *     <li>dataWystawienia (data wystawienia mandatu)</li>
 *     <li>miejsce (miejsce wystawienia mandatu)</li>
 *     <li>punkty (ilość punktów karnych przypisanych do wykroczenia)</li>
 *     <li>recydywa (czy kierowca był już karany za podobne wykroczenie i mandat będzie 2x droższy)</li>
 *     <li>kwota (kwota wystawionego mandatu)</li>
 *     <li>status (aktualny status mandatu: aktywny lub anulowany)</li>
 * </ul>
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Mandates")
public class Mandate {

    /**
     * Unikalne id mandatu.
     * Generowany automatycznie przy użyciu stworzonej sekwencji "mandate_sequence".
     */
    @Id
    @SequenceGenerator(
            name = "mandate_sequence",
            sequenceName = "mandate_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "mandate_sequence"
    )
    private Long id;

    /**
     * Policjant, który wystawił mandat.
     * Pole obce (foreign key) do encji Policjant.
     */
    @ManyToOne
    @JoinColumn(name = "IdPolicjanta", referencedColumnName = "numerSluzbowy", nullable = false)
    private Policeman policjant;

    /**
     * Kierowca, który otrzymał mandat.
     * Pole obce (foreign key) do encji Kierowca.
     */

    @ManyToOne
    @JoinColumn(name = "IdKierowcy", referencedColumnName = "id", nullable = false)
    private Driver kierowca;

    /**
     * Opis wykroczenia, które zostało popełnione przez kierowcę.
     * Kolumna która nie może mieć wartości null.
     */
    @Column(nullable = false)
    private String wykroczenie;

    /**
     * Data wystawienia mandatu.
     * Kolumna która nie może mieć wartości null.
     */
    @Column(nullable = false)
    private Date dataWystawienia;

    /**
     * Miejsce, gdzie mandat został wystawiony.
     * Kolumna która nie może mieć wartości null.
     */
    @Column(nullable = false)
    private String miejsce;

    /**
     * Liczba punktów karnych przypisana do wykroczenia.
     * Kolumna która nie może mieć wartości null.
     */
    @Column(nullable = false)
    private Integer punkty;

    /**
     * Informacja o tym, czy kierowca był już karany za podobne wykroczenie (recydywa).
     * Kolumna która nie może mieć wartości null.
     */
    @Column(nullable = false)
    private Boolean recydywa;

    /**
     * Kwota mandatu w złotych.
     * Kolumna która nie może mieć wartości null.
     */
    @Column(nullable = false)
    private Float kwota;

    /**
     * Status mandatu, może być aktywny lub anulowany.
     * Kolumna która nie może mieć wartości null.
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    /**
     * Metoda sprawdzająca czy kierowca posiada już podobne wykroczenie
     * i czy będzie recydywa.
     *
     * @return String "TAK" jeśli jest recydywa, w przeciwnym razie "NIE"
     */
    public String getRecydywa() {
        return recydywa ? "TAK" : "NIE";
    }
}
