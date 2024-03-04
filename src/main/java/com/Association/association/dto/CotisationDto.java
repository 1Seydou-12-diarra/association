package com.Association.association.dto;



import com.Association.association.entity.Cotisation;
import lombok.Getter;

public class CotisationDto {


    @Getter
    private String datePaiement;
    private double montant;
    @Getter

    private  String membre;

    public CotisationDto() {

    }

    public CotisationDto(String datePaiement, double montant,String membre) {
        this.datePaiement = datePaiement;
        this.montant = montant;

        this.membre = membre;
    }

    public CotisationDto(Cotisation cotisation) {
        this.datePaiement = cotisation.getDatePaiement();
        this.montant = cotisation.getMontant();

    }

    public String getDatePaiement() {
        return datePaiement;
    }

    public double getMontant() {
        return montant;
    }



    public String getMembre() {
        return membre;
    }
}

