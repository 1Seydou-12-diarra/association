package com.Association.association.entity;


import com.Association.association.enums.StatutMembre;
import jakarta.persistence.*;

import java.util.List;

import static org.apache.logging.log4j.util.Strings.isBlank;

@Entity
@Table(name = "membre")
public class Membre{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;


    @Column(name = "contact")
    private String contact;


    @Column(name = "email")
    private String email;

    @Column(name = "residence")
    private String residence;


    @Enumerated(EnumType.STRING)
    @Column(name = "statut")
    private  StatutMembre statut;
    @OneToMany(mappedBy = "membre", cascade = CascadeType.ALL)
    private List<Cotisation> cotisations;


    public Membre() {

    }

    public Membre(String nom, String prenom, String contact,  String email, String residence,StatutMembre statut) {
        this.nom = nom;
        this.prenom = prenom;
        this.contact = contact;
        this.email = email;
        this.residence = residence;
        this.statut = statut;
        this.cotisations =cotisations;

    }



    public void mettreAJour(String nom,  String contact, String email, StatutMembre statut) {
        if (!isBlank(nom)) {
            this.nom = nom;
        }

        if (!isBlank(contact)) {
            this.contact = contact;
        }
        if (!isBlank(email)) {
            this.email = email.toLowerCase().trim();
        }
        if (statut != null) {
            this.statut = statut;
        }
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

    public StatutMembre getStatut() {
        return statut;
    }

    public List<Cotisation> getCotisations() {
        return cotisations;
    }
}