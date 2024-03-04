package com.Association.association.controller;


import com.Association.association.dto.MembreDto;
import com.Association.association.dto.MembreTableauDto;
import com.Association.association.facade.FacadeMembre;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/membre")
class MembreController {
    private final FacadeMembre facadeMembre;

    public MembreController(FacadeMembre facadeMembre) {
        this.facadeMembre = facadeMembre;
    }

    @GetMapping("/lister")
    public MembreTableauDto listerMembres() {
        return facadeMembre.lister();
    }

    @PostMapping("/enregistrerOuModifier")
    public void enregistrerMembre(@RequestBody MembreDto membreDto) {
        facadeMembre.enregistrerOuModifier(membreDto);
    }

    @PostMapping("/delete")
    public void supprimerMembre(@RequestBody MembreDto membreDto) {
        facadeMembre.supprimerMembre(membreDto);
    }
}

