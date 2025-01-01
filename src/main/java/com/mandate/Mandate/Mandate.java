package com.mandate.Mandate;

import com.mandate.Driver.Driver;
import com.mandate.Policeman.Policeman;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Mandates")
public class Mandate {
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

    @ManyToOne
    @JoinColumn(name = "IdPolicjanta", referencedColumnName = "numerSluzbowy", nullable = false)
    private Policeman policjant;

    @ManyToOne
    @JoinColumn(name = "IdKierowcy", referencedColumnName = "id", nullable = false)
    private Driver kierowca;

    @Column(nullable = false)
    private String wykroczenie;

    @Column(nullable = false)
    private Date dataWystawienia;

    @Column(nullable = false)
    private String miejsce;

    @Column(nullable = false)
    private Integer punkty;

    @Column(nullable = false)
    private Boolean recydywa;

    @Column(nullable = false)
    private Float kwota;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public String getRecydywa() {
        return recydywa ? "TAK" : "NIE";
    }
}
