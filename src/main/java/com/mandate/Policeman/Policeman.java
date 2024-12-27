package com.mandate.Policeman;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Policemen")
@AllArgsConstructor
@NoArgsConstructor
public class Policeman {
    @Id
    @Column(nullable = false)
    private Long numerSluzbowy;

    @Column(nullable = false)
    private String imie;

    @Column(nullable = false)
    private String nazwisko;

    @Column(nullable = false)
    private String pesel;

    public String toString() {
        return "PolicemanID: " + this.numerSluzbowy + ". " + this.imie + " " + this.nazwisko + " " + pesel;
    }

}