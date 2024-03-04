package com.Association.association.dto;


import com.Association.association.entity.Membre;
import com.Association.association.enums.StatutMembre;
import lombok.Getter;


public class MembreDto {


    private String nom;

    private String prenom;

    private String contact;


    private String email;

    private String residence;

    private String statut;
    private  String cotisation;


    /**
     *
     */
    private MembreDto() {

    }

    public MembreDto(String nom, String prenom, String contact, String email, String residence, String statut,String cotisation) {
        this.nom = nom;
        this.prenom = prenom;
        this.contact = contact;
        this.email = email;
        this.residence = residence;
        this.statut = statut;
        this.cotisation = cotisation;
    }

    public MembreDto(Membre membre) {
        this.nom = membre.getNom();
        this.prenom = membre.getPrenom();
        this.contact = membre.getContact();
        this.email = membre.getEmail();
        this.residence = membre.getResidence();
        this.statut = membre.getStatut().getDesignation();
    }



    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getResidence() {
        return residence;
    }

    public String getStatut() {
        return statut;
    }


    }

