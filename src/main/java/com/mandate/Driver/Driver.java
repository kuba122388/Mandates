package com.mandate.Driver;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Drivers")
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    @Id
    @SequenceGenerator(
            name = "driver_sequence",
            sequenceName = "driver_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "driver_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private String imie;

    @Column(nullable = false)
    private String nazwisko;

    @Column(nullable = false)
    private String pesel;

    Driver(String imie, String nazwisko, String pesel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
    }

    public String toString() {
        return "DriverID: " + this.id + ". " + this.imie + " " + this.nazwisko + " " + pesel;
    }
}