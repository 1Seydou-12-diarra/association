package com.Association.association.facade;

import com.Association.association.dto.MembreDto;
import com.Association.association.dto.MembreTableauDto;
import com.Association.association.entity.Membre;
import com.Association.association.enums.StatutMembre;
import com.Association.association.repository.MembreRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;

@Service
public class FacadeMembre {
    private final MembreRepository membreRepository;

    public FacadeMembre(MembreRepository membreRepository) {
        this.membreRepository = membreRepository;
    }

    public MembreTableauDto lister() {
        List<Membre> listeMembres = membreRepository.findAll();

        Long totalMembres = (long) listeMembres.size();
        Map<Boolean, Long> map = listeMembres.stream()
                .collect(partitioningBy((Membre membre) -> (StatutMembre.ACTIF.equals(membre.getStatut())), counting()));
        long membresActifs = map.get(true);
        long membresInactifs = map.get(false);
        List<MembreDto> membres = listeMembres.stream()
                .map(MembreDto::new)
                .collect(Collectors.toList());

        return new MembreTableauDto(totalMembres, membresActifs, membresInactifs, membres);
    }

    @Transactional
    public void enregistrerOuModifier(MembreDto membreDto) {
        Membre membre = membreRepository.findByPrenom(membreDto.getPrenom()).orElse(null);
        if (membre == null) {
            membre = new Membre(membreDto.getNom(), membreDto.getPrenom(), membreDto.getContact(),
                    membreDto.getEmail(),membreDto.getResidence(), StatutMembre.valueOf(membreDto.getStatut()));
        } else {
            membre.mettreAJour(membreDto.getNom(),membreDto.getContact(),
                    membreDto.getEmail(), StatutMembre.valueOf(membreDto.getStatut()));
        }
        membreRepository.save(membre);
    }

    @Transactional
    public void supprimerMembre(MembreDto membreDto) {
        Membre membre = membreRepository.findByPrenom(membreDto.getPrenom()).orElse(null);
        if (membre != null) {
            membreRepository.delete(membre);
        }
    }

}

