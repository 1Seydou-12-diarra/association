package com.Association.association.dto;

import com.Association.association.entity.Membre;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
public class MembreTableauDto {
    private Long totalMembres;
    private long membresActifs;
    private long membresInactifs;
    private List<MembreDto> membres;

    public MembreTableauDto(Long totalMembres, long membresActifs, long membresInactifs, List<MembreDto> membres) {
        this.totalMembres = totalMembres;
        this.membresActifs = membresActifs;
        this.membresInactifs = membresInactifs;
        this.membres = membres;
    }

    public static class CotisationDTO {

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate datePaiement;

        private BigDecimal montant;

        private Membre membre;

        public CotisationDTO() {
        }

        public CotisationDTO(LocalDate datePaiement, BigDecimal montant, Membre membre) {
            this.datePaiement = datePaiement;
            this.montant = montant;
            this.membre = membre;
        }

        public LocalDate getDatePaiement() {
            return datePaiement;
        }

        public BigDecimal getMontant() {
            return montant;
        }


        public Membre getMembre() {
         return   membre;

        }
    }
}
