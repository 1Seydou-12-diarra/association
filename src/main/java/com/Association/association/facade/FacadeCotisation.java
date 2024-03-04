package com.Association.association.facade;


import com.Association.association.dto.CotisationDto;
import com.Association.association.dto.CotisationTableauDto;
import com.Association.association.entity.Cotisation;
import com.Association.association.entity.Membre;
import com.Association.association.repository.CotisationRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacadeCotisation {
    private final CotisationRepository cotisationRepository;

    public FacadeCotisation(CotisationRepository cotisationRepository) {
        this.cotisationRepository = cotisationRepository;
    }

    public CotisationTableauDto lister() {
        List<Cotisation> listeCotisations = cotisationRepository.findAll();

        long totalCotisations = listeCotisations.size();
        List<CotisationDto> cotisations = listeCotisations.stream()
                .map(CotisationDto::new)
                .collect(Collectors.toList());

        return new CotisationTableauDto(totalCotisations, cotisations);
    }

    @Transactional
    public void enregistrerOuModifier(CotisationDto cotisationDto) {
        Cotisation cotisation = cotisationRepository.findByDatePaiement(cotisationDto.getDatePaiement()).orElse(null);
        if (cotisation == null) {
            cotisation = new Cotisation();
            cotisation.getMontant();
            cotisation.getDatePaiement();
            // Vous devrez définir les autres attributs de cotisation en fonction de votre modèle
        }else {
            cotisation.mettreAJour(cotisationDto.getMontant());
        }
        cotisationRepository.save(cotisation);
    }



    // Ajoutez d'autres méthodes de recherche ou de gestion selon vos besoins
}

