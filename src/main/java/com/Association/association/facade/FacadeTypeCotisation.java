package com.Association.association.facade;

import com.Association.association.dto.MembreDto;
import com.Association.association.dto.MembreTableauDto;
import com.Association.association.dto.TypeCotisationDto;
import com.Association.association.dto.TypeCotisationTableauDto;
import com.Association.association.entity.Membre;
import com.Association.association.entity.TypeCotisation;
import com.Association.association.enums.StatutMembre;
import com.Association.association.repository.TypeCotisationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;

@Service
public class FacadeTypeCotisation {
    public  final TypeCotisationRepository typeCotisationRepository;

    public FacadeTypeCotisation(TypeCotisationRepository typeCotisationRepository) {
        this.typeCotisationRepository = typeCotisationRepository;
    }

    public TypeCotisationTableauDto lister() {
        List<TypeCotisation> listeTypeCotisations = typeCotisationRepository.findAll();

        Long totalTypeCotisation= (long) listeTypeCotisations.size();
        Map<Boolean, Long> map = listeTypeCotisations.stream()

        List<TypeCotisationDto> typeCotisation;
        typeCotisation = listeTypeCotisations.stream()
                .map(TypeCotisationDto::new)
                .collect(Collectors.toList());

        return new MembreTableauDto(totalTypeCotisation, typeCotisation);
    }



}
