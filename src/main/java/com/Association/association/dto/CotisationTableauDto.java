package com.Association.association.dto;



import lombok.Getter;
import java.util.List;

@Getter
public class CotisationTableauDto {
    private Long totalCotisations;
    private List<CotisationDto> cotisations;

    public CotisationTableauDto(Long totalCotisations, List<CotisationDto> cotisations) {
        this.totalCotisations = totalCotisations;
        this.cotisations = cotisations;
    }
}

