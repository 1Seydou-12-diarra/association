package com.Association.association.controller;


import com.Association.association.dto.MembreDto;
import com.Association.association.dto.MembreTableauDto;
import com.Association.association.facade.FacadeMembre;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> enregistrerMembre(@RequestBody MembreDto membreDto) {
        facadeMembre.enregistrerOuModifier(membreDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Membre ajoutée avec succès.");
    }

 }

