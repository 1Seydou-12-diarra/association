package com.Association.association.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Entity
    @Table(name =Cotisation.TABLE_NAME)
    public class Cotisation {
        public static final String TABLE_NAME = "cotisation";

        public static final String TABLE_ID = TABLE_NAME + "_id";

        public static final String TABLE_SEQ = TABLE_ID + "_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_paiement")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datePaiement;

    @Column(name = "montant")
    private BigDecimal montant;

    @lombok.Setter
    @lombok.Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "membre", referencedColumnName = "id")

    private Membre membre;

    public Cotisation() {}

    public Cotisation(Long id, LocalDate datePaiement, BigDecimal montant, Membre membre) {
        this.id = id;
        this.datePaiement = datePaiement;
        this.montant = montant;
        this.membre = membre;
    }



        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(LocalDate datePaiement) {
        this.datePaiement = datePaiement;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    }











