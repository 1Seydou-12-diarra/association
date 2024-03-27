package com.Association.association.dto;

import com.Association.association.entity.TypeCotisation;

public class TypeCotisationDto {
    private Long id;
    private String libelle;
    private String description;
    public  TypeCotisationDto(){}

    public TypeCotisationDto(Long id, String libelle, String description) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
