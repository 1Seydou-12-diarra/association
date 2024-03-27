package com.Association.association.dto;


import com.Association.association.entity.Membre;

public class MembreDto {


    private Long id;
    private String nom;

    private String prenom;

    private String contact;


    private String email;

    private String residence;

    private String statut;


    public  MembreDto(){

    }
    public MembreDto(Long id, String nom, String prenom, String contact, String email, String residence, String statut) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.contact = contact;
        this.email = email;
        this.residence = residence;
        this.statut = statut;
    }

    public MembreDto(Membre membre) {

        this.nom = membre.getNom();
        this.prenom = membre.getPrenom();
        this.contact = membre.getContact();
        this.email = membre.getEmail();
        this.residence = membre.getResidence();
        this.statut = membre.getStatut().getDesignation();
    }


    public Long getId() {
        return id;
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

