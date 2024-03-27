package com.Association.association.controller;


import com.Association.association.dto.CotisationTableauDto;
import com.Association.association.dto.MembreTableauDto;
import com.Association.association.facade.FacadeCotisation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cotisations")
public class CotisationController {

    private final FacadeCotisation facadeCotisation;
    public CotisationController(FacadeCotisation facadeCotisation) {
        this.facadeCotisation = facadeCotisation;
    }

    @GetMapping("/lister")
    public CotisationTableauDto listerCotisations() {
        return facadeCotisation.lister();
    }

    @PostMapping("/ajouter")
    public ResponseEntity<String> ajouterCotisation(@RequestBody MembreTableauDto.CotisationDTO cotisationDto) {
        facadeCotisation.enregistrerOuModifier(cotisationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cotisation ajoutée avec succès.");
    }


}
