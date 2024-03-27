package com.Association.association.dto;

import com.Association.association.entity.Cotisation;
import com.Association.association.entity.Membre;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
public class CotisationDto {
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datePaiement;


    private BigDecimal montant;

    private Membre membre;

    public void CotisationDTO() {}

    public CotisationDto(Cotisation cotisation) {
        this.id = cotisation.getId();
        this.datePaiement = cotisation.getDatePaiement();
        this.montant = cotisation.getMontant() ;
        this.membre = cotisation.getMembre();
    }

}

