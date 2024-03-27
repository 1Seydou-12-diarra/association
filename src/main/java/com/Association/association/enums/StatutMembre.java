package com.Association.association.enums;


import lombok.Getter;

@Getter
public enum StatutMembre {
    ACTIF("Actif"), INACTIF("Inactif");

    private final String designation;

    StatutMembre(String designation) {
        this.designation = designation;
    }

}
