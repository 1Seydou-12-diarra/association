package com.Association.association.entity;


import jakarta.persistence.*;
import lombok.Getter;

import static io.micrometer.common.util.StringUtils.isBlank;
import static java.lang.Integer.parseInt;

@Entity
@Table(name = "cotisation")
public class Cotisation {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cotisation;

    @Getter
    @Column(name = "date_paiement")
    private String datePaiement;

    @Column(name = "montant")
    private double montant;

    @lombok.Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_membre")
    private Membre membre;


    public Cotisation() {
    }

    public Cotisation(Long id_cotisation, String datePaiement, double montant, Membre membre) {
        this.id_cotisation = id_cotisation;
        this.datePaiement = datePaiement;
        this.montant = montant;
        this.membre = membre;
    }

    public void mettreAJour(double montant) {

        if (!isBlank(String.valueOf(montant))){
            this.montant= parseInt(String.valueOf(montant));
        }
       
    }

    public Long getId_cotisation() {
        return id_cotisation;
    }

    public String getDatePaiement() {
        return datePaiement;
    }

    public double getMontant() {
        return montant;
    }

    public Membre getMembre() {
        return membre;
    }
}
