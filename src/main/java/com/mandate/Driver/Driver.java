package com.mandate.Driver;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Klasa reprezentująca encję "Driver" w aplikacji.
 * Mapuje klasę Driver na tabelę "Drivers" w bazie danych.
 *
 * <p>Struktura tabeli:
 * <ul>
 *     <li>id (klucz główny, generowany automatycznie)</li>
 *     <li>imie (imie kierowcy, nie może być null)</li>
 *     <li>nazwisko (nazwisko kierowcy, nie może być null)</li>
 *     <li>pesel (pesel kierowcy, nie może być null)</li>
 * </ul>
 * </p>
 */
@Data
@Entity
@Table(name = "Drivers")
@AllArgsConstructor
@NoArgsConstructor
public class Driver {

    /**
     * Unikalny identyfikator kierowcy.
     * Generowany automatycznie przy użyciu stworzonej sekwencji "driver_sequence".
     */
    @Id
    @SequenceGenerator(name = "driver_sequence", sequenceName = "driver_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "driver_sequence")
    private Long id;

    /**
     * Imię kierowcy.
     * Kolumna która nie może mieć wartości null.
     */
    @Column(nullable = false)
    private String imie;

    /**
     * Nazwisko kierowcy.
     * Kolumna która nie może mieć wartości null.
     */
    @Column(nullable = false)
    private String nazwisko;

    /**
     * Numer PESEL kierowcy.
     * Kolumna która nie może mieć wartości null.
     */
    @Column(nullable = false)
    private String pesel;

    /**
     * Konstruktor tworzący obiekt klasy Driver.
     *
     * @param imie     imię kierowcy
     * @param nazwisko nazwisko kierowcy
     * @param pesel    numer PESEL kierowcy
     */
    Driver(String imie, String nazwisko, String pesel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
    }

    /**
     * Nadpisana metoda toString służąca do wyświetlenia kierowcy.
     *
     * @return Tekstowa reprezenatcja kierowcy wyświetlająca go w postaci:
     * Driver ID + (ID kierowcy) + (Imie kierowcy) + (Nazwisko kierowcy) + (PESEL kierowcy)
     */
    @Override
    public String toString() {
        return "DriverID: " + this.id + ". " + this.imie + " " + this.nazwisko + " " + pesel;
    }
}
