package com.Association.association.entity;


import com.Association.association.enums.StatutMembre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.util.List;

import static org.apache.logging.log4j.util.Strings.isBlank;

    @Entity
    @Table(name = Membre.TABLE_NAME)
    public class Membre {
        public static final String TABLE_NAME = "membre";

        public static final String TABLE_ID = TABLE_NAME + "_id";

        public static final String TABLE_SEQ = TABLE_ID + "_seq";

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
    private StatutMembre statut;

    @lombok.Setter
    @lombok.Getter
    @OneToMany(mappedBy = "membre", cascade = CascadeType.ALL)

    private List<Cotisation> cotisations;

    public Membre() {
    }
        public Membre(String id) {
            this.id = Long.parseLong(id);
        }

    public Membre(Long id, String nom, String prenom, String contact, String email, String residence, StatutMembre statut) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.contact = contact;
        this.email = email;
        this.residence = residence;
        this.statut = statut;

    }

    public void mettreAJour(String nom, String contact, String email, StatutMembre statut) {
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

        public void setId(Long id) {
            this.id = id;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setResidence(String residence) {
            this.residence = residence;
        }

        public void setStatut(StatutMembre statut) {
            this.statut = statut;
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

    }



