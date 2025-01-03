package com.mandate.Policeman;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Klasa reprezentująca encję "Policeman" w aplikacji.
 * Mapuje klasę Policeman na tabelę "Policemen" w bazie danych.
 *
 * <p>Każdy policjant posiada unikalny numer służbowy, imię, nazwisko oraz numer PESEL.
 */
@Data
@Entity
@Table(name = "Policemen")
@AllArgsConstructor
@NoArgsConstructor
public class Policeman {

    /**
     * Unikalny numer służbowy policjanta.
     */
    @Id
    @Column(nullable = false)
    private Long numerSluzbowy;

    /**
     * Imię policjanta.
     */
    @Column(nullable = false)
    private String imie;

    /**
     * Nazwisko policjanta.
     */
    @Column(nullable = false)
    private String nazwisko;

    /**
     * Numer PESEL policjanta.
     */
    @Column(nullable = false)
    private String pesel;

    /**
     * Zwraca reprezentację tekstową obiektu Policeman.
     *
     * @return Tekst zawierający numer służbowy, imię, nazwisko i PESEL policjanta.
     */
    @Override
    public String toString() {
        return "PolicemanID: " + this.numerSluzbowy + ". " + this.imie + " " + this.nazwisko + " " + pesel;
    }
}
