package com.Association.association.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Entity
@Table(name = TypeCotisation.TABLE_NAME)
public class TypeCotisation {
    public static final String TABLE_NAME = "type_cotisation";

    public static final String TABLE_ID = TABLE_NAME + "_id";

    public static final String TABLE_SEQ = TABLE_ID + "_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "libelle")
    private String  libelle;
    @Column(name = "description")
    private String  description;

    @OneToMany(mappedBy = "type_cotisation", cascade = CascadeType.ALL)
    private List<Cotisation> cotisations;

    public  TypeCotisation(){}

    public TypeCotisation(Long id, String libelle, String description) {
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

    public List<Cotisation> getCotisations() {
        return cotisations;
    }

    public void setCotisations(List<Cotisation> cotisations) {
        this.cotisations = cotisations;
    }
}
