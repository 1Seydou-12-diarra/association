package com.Association.association.facade;

import com.Association.association.dto.CotisationDto;
import com.Association.association.dto.CotisationTableauDto;
import com.Association.association.dto.MembreTableauDto;
import com.Association.association.entity.Cotisation;
import com.Association.association.entity.Membre;
import com.Association.association.repository.CotisationRepository;
import com.Association.association.repository.MembreRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class FacadeCotisation {
    @Autowired
    private  CotisationRepository cotisationRepository;
    @Autowired
    private  MembreRepository membreRepository;


    public CotisationTableauDto lister() {
        List<Cotisation> listeCotisations = cotisationRepository.findAll();

        Long totalCotisations = (long) listeCotisations.size();
        BigDecimal montantTotal = BigDecimal.ZERO;
        LocalDate dateDerniereCotisation = null;

        for (Cotisation cotisation : listeCotisations) {
            montantTotal = montantTotal.add(cotisation.getMontant());
            if (dateDerniereCotisation == null || cotisation.getDatePaiement().isAfter(dateDerniereCotisation)) {
                dateDerniereCotisation = cotisation.getDatePaiement();
            }
        }
        return new CotisationTableauDto(totalCotisations);
    }

    @Transactional
    public CotisationDto enregistrerOuModifier(MembreTableauDto.CotisationDTO cotisationDto) {
        Membre membre = membreRepository.findById(cotisationDto.getMembre().getId()) .orElseThrow(() -> new IllegalArgumentException("membre introuvable"));
        if (membre == null) {
            throw new IllegalArgumentException("Membre invalide");
        }

         Cotisation   cotisation = new Cotisation( cotisationDto.getMembre().getId(),cotisationDto.getDatePaiement(), cotisationDto.getMontant(),membre);
        Cotisation savedCotisations = cotisationRepository.save(cotisation);
        return new CotisationDto(savedCotisations);
    }


}
