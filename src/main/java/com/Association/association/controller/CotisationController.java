package com.Association.association.controller;
import com.Association.association.dto.CotisationDto;
import com.Association.association.dto.CotisationTableauDto;
import com.Association.association.facade.FacadeCotisation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cotisation")
class CotisationController {
    private final FacadeCotisation facadeCotisation;

    public CotisationController(FacadeCotisation facadeCotisation) {
        this.facadeCotisation = facadeCotisation;
    }

    @GetMapping("/lister")
    public CotisationTableauDto listerCotisations() {
        return facadeCotisation.lister();
    }

    @PostMapping("/enregistrerOuModifier")
    public void enregistrerCotisation(@RequestBody CotisationDto cotisationDto) {
        facadeCotisation.enregistrerOuModifier(cotisationDto);
    }


}
