package com.Association.association.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class MembreTableauDto {
    private Long totalMembres;
    private long membresActifs;
    private long membresInactifs;
    private List<MembreDto> membres;

    public MembreTableauDto(Long totalMembres, long membresActifs, long membresInactifs, List<MembreDto> membres) {
        this.totalMembres = totalMembres;
        this.membresActifs = membresActifs;
        this.membresInactifs = membresInactifs;
        this.membres = membres;
    }

}
